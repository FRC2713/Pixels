package pixels.Foundation;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import pixels.Canvas;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    private final Canvas canvas = new Canvas();

    private final String vertex_shader0 =
            "#version 330\n in vec3 position;\n in vec2 texcoord;\n out vec2 out_texcoord;\n void main() {\n gl_Position = vec4(position,1.0) ;\n out_texcoord = texcoord ;\n}";

    private final String fragment_shader0 =
            "#version 330\n in vec2 out_texcoord;\n out vec4 fragmentColor;\n vec2 texcoord;\nuniform sampler2D pixels_texture_0;\n void main() {\n fragmentColor = (texture(pixels_texture_0, out_texcoord.st));\n}";

    private final float[] quad_pos_array = {
            -1.0f, 1.0f, 0.0f,
            1.0f, 1.0f, 0.0f,
            1.0f, -1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f
    };

    private final float[] quad_texcoord_array = {
            0.0f, 1.0f,
            1.0f, 1.0f,
            1.0f, 0.0f,
            0.0f, 0.0f
    };

    private final int[] quad_elementArray_array = {
            0, 2, 1,
            0, 3, 2
    };

    private int mesh = 0;
    private int shader = 0;
    private final int[] mesh_ebo = new int[1];
    private int texture = 0;

    private static void construct_attribute(int index, float[] data, int num_of_data_per_element) {
        int vbo = 0;
        int stride = 4;
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
        glEnableVertexAttribArray(index);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(index, num_of_data_per_element, GL_FLOAT, false, num_of_data_per_element * stride, 0);
    }

    private int make_vao(int[] getebo, int vertex_count, int[] indexes, int index_count) {
        int vao = 0;
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        construct_attribute(0, quad_pos_array, 3);
        construct_attribute(1, quad_texcoord_array, 2);

        if (indexes != null) {
            int ebo;
            ebo = glGenBuffers();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexes, GL_STATIC_DRAW);
            getebo[0] = ebo;
        }

        return vao;
    }

    private int build_shaders(String vertex_source, String fragment_source) {
        int vertex_shader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertex_shader, vertex_source);
        glCompileShader(vertex_shader);

        int fragment_shader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragment_shader, fragment_source);
        glCompileShader(fragment_shader);

        int shader_program = glCreateProgram();

        glBindAttribLocation(shader_program, 0, "position");
        glBindAttribLocation(shader_program, 1, "texcoord");

        glAttachShader(shader_program, vertex_shader);
        glAttachShader(shader_program, fragment_shader);
        glLinkProgram(shader_program);

        glValidateProgram(shader_program);

        glUseProgram(shader_program);
        return shader_program;
    }

    private int load_texture_to_opengl(int[] rawdata, int x, int y, int iformat, int format, int type) {
        int tex_name = 0;
        tex_name = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, tex_name);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, iformat, x, y, 0, format, type, rawdata);
        glGenerateMipmap(GL_TEXTURE_2D);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_LOD_BIAS, 0);
        return tex_name;
    }

    private int load_texture_to_opengl(IntBuffer rawdata) {
        return load_texture_to_opengl(rawdata.array(), Texture.x, Texture.y, GL_RGBA8, GL_RGBA, GL_UNSIGNED_INT_8_8_8_8_REV);
    }

    // The window handle
    private long window;

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        mesh = make_vao(mesh_ebo, 4, quad_elementArray_array, 6);
        shader = build_shaders(vertex_shader0, fragment_shader0);
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(1366, 768, "Hello World!", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            canvas.getKey(key, action);
        });

        glfwSetCursorPosCallback(window, (window, xpos, ypos) -> {
            ypos = (ypos < 1) ? Texture.y : Texture.y - ypos;
            canvas.getMousePos((int) xpos, (int) ypos);
        });

        glfwSetMouseButtonCallback(window, (window, button, action, mods) -> {
            canvas.getMouseButton(button, action);
        });

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
    }

    private void loop() {
        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        int[] width = new int[1], height = new int[1];
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();

            glfwGetWindowSize(window, width, height);
            glViewport(0, 0, width[0], height[0]);

            glEnable(GL_DEPTH_TEST);
            glEnable(GL_CULL_FACE);

            canvas.draw();

            texture = load_texture_to_opengl(Texture.rawdata);

            Texture.reset();

            glUseProgram(shader);

            glActiveTexture(GL_TEXTURE0);
            glBindTexture(GL_TEXTURE_2D, texture);
            glUniform1i(glGetUniformLocation(shader, "pixels_texture_0"), 0);

            glBindVertexArray(mesh);

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, mesh_ebo[0]);

            glDrawElements(GL_TRIANGLES, quad_elementArray_array.length, GL_UNSIGNED_INT, 0);

            glfwSwapBuffers(window); // swap the color buffers
            glDeleteTextures(texture);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

}

