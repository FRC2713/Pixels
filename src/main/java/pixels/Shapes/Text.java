package pixels.Shapes;

import java.nio.charset.StandardCharsets;

public class Text extends Shape {

    private String text;
    private int size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void rectangle(int width, int height, int posX, int posY, int red, int green, int blue) {
        int i = 0;
        int j = 0;
        while (i < width) {
            j = 0;
            while (j < height) {
                setPixel(i + posX, j + posY, red, green, blue);
                j++;
            }
            i++;
        }
    }

   private void dotline(int[] line, int x, int y, int size, int red, int green, int blue) {
        int i = 0 ;
        int spaces = 0 ;
        if (line != null) {
            while (line[i] != -1) {
                if (line[i] == 1) {
                    rectangle(size, size, x + (spaces * size), y, red, green, blue) ;
                }
                i++ ;
                spaces++ ;
            }
        }
    }

    private void drawChar(byte c, int size, int x, int y, int red, int green, int blue) {
        //A
        int[] A1 =  {0,0,1,0,0,-1} ;
        int[] A2 =  {0,1,0,1,0,-1} ;
        int[] A3 =  {0,1,1,1,0,-1} ;
        int[] A4 =  {0,1,0,1,0,-1} ;
        int[] A5 =  {0,1,0,1,0,-1} ;
        //B
        int[] B1 = {0,1,1,0,0,-1} ;
        int[] B2 = {0,1,0,1,0,-1} ;
        int[] B3 = {0,1,1,1,0,-1} ;
        int[] B4 = {0,1,0,1,0,-1} ;
        int[] B5 = {0,1,1,0,0,-1} ;
        //C
        int[] C1 = {0,0,1,1,0,-1} ;
        int[] C2 = {0,1,0,0,0,-1} ;
        int[] C3 = {0,1,0,0,0,-1} ;
        int[] C4 = {0,1,0,0,0,-1} ;
        int[] C5 = {0,0,1,1,0,-1} ;
        //D
        int[] D1 = {0,1,1,0,0,-1} ;
        int[] D2 = {0,1,0,1,0,-1} ;
        int[] D3 = {0,1,0,1,0,-1} ;
        int[] D4 = {0,1,0,1,0,-1} ;
        int[] D5 = {0,1,1,0,0,-1} ;
        //E
        int[] E1 = {0,1,1,1,0,-1} ;
        int[] E2 = {0,1,0,0,0,-1} ;
        int[] E3 = {0,1,1,0,0,-1} ;
        int[] E4 = {0,1,0,0,0,-1} ;
        int[] E5 = {0,1,1,1,0,-1} ;
        //F
        int[] F1 = {0,1,1,1,0,-1} ;
        int[] F2 = {0,1,0,0,0,-1} ;
        int[] F3 = {0,1,1,1,0,-1} ;
        int[] F4 = {0,1,0,0,0,-1} ;
        int[] F5 = {0,1,0,0,0,-1} ;
        //G
        int[] G1 = {0,1,1,1,0,-1} ;
        int[] G2 = {0,1,0,0,0,-1} ;
        int[] G3 = {0,1,0,1,0,-1} ;
        int[] G4 = {0,1,0,1,0,-1} ;
        int[] G5 = {0,1,1,1,0,-1} ;
        //H
        int[] H1 = {0,1,0,1,0,-1} ;
        int[] H2 = {0,1,0,1,0,-1} ;
        int[] H3 = {0,1,1,1,0,-1} ;
        int[] H4 = {0,1,0,1,0,-1} ;
        int[] H5 = {0,1,0,1,0,-1} ;
        //I
        int[] I1 = {0,1,1,1,0,-1} ;
        int[] I2 = {0,0,1,0,0,-1} ;
        int[] I3 = {0,0,1,0,0,-1} ;
        int[] I4 = {0,0,1,0,0,-1} ;
        int[] I5 = {0,1,1,1,0,-1} ;
        //J
        int[] J1 = {0,1,1,1,0,-1} ;
        int[] J2 = {0,0,1,0,0,-1} ;
        int[] J3 = {0,0,1,0,0,-1} ;
        int[] J4 = {0,0,1,0,0,-1} ;
        int[] J5 = {0,1,1,0,0,-1} ;
        //K
        int[] K1 = {0,1,0,1,0,-1} ;
        int[] K2 = {0,1,1,0,0,-1} ;
        int[] K3 = {0,1,1,0,0,-1} ;
        int[] K4 = {0,1,1,0,0,-1} ;
        int[] K5 = {0,1,0,1,0,-1} ;
        //L
        int[] L1 = {0,1,0,0,0,-1} ;
        int[] L2 = {0,1,0,0,0,-1} ;
        int[] L3 = {0,1,0,0,0,-1} ;
        int[] L4 = {0,1,0,0,0,-1} ;
        int[] L5 = {0,1,1,1,0,-1} ;
        //M
        int[] M1 = {1,1,0,1,1,-1} ;
        int[] M2 = {1,0,1,0,1,-1} ;
        int[] M3 = {1,0,1,0,1,-1} ;
        int[] M4 = {1,0,1,0,1,-1} ;
        int[] M5 = {1,0,0,0,1,-1} ;
        //N
        int[] N1 = {0,1,0,0,1,-1} ;
        int[] N2 = {0,1,1,0,1,-1} ;
        int[] N3 = {0,1,0,1,1,-1} ;
        int[] N4 = {0,1,0,0,1,-1} ;
        int[] N5 = {0,1,0,0,1,-1} ;
        //O
        int[] O1 = {0,1,1,1,0,-1} ;
        int[] O2 = {0,1,0,1,0,-1} ;
        int[] O3 = {0,1,0,1,0,-1} ;
        int[] O4 = {0,1,0,1,0,-1} ;
        int[] O5 = {0,1,1,1,0,-1} ;
        //P
        int[] P1 = {0,1,1,1,0,-1} ;
        int[] P2 = {0,1,0,1,0,-1} ;
        int[] P3 = {0,1,1,1,0,-1} ;
        int[] P4 = {0,1,0,0,0,-1} ;
        int[] P5 = {0,1,0,0,0,-1} ;
        //Q
        int[] Q1 = {0,1,1,1,0,-1} ;
        int[] Q2 = {0,1,0,1,0,-1} ;
        int[] Q3 = {0,1,0,1,0,-1} ;
        int[] Q4 = {0,1,1,1,0,-1} ;
        int[] Q5 = {0,0,0,1,0,-1} ;
        //R
        int[] R1 = {0,1,1,1,0,-1} ;
        int[] R2 = {0,1,0,1,0,-1} ;
        int[] R3 = {0,1,1,0,0,-1} ;
        int[] R4 = {0,1,0,1,0,-1} ;
        int[] R5 = {0,1,0,0,1,-1} ;
        //S
        int[] S1 = {0,0,1,1,0,-1} ;
        int[] S2 = {0,0,1,0,0,-1} ;
        int[] S3 = {0,0,1,0,0,-1} ;
        int[] S4 = {0,0,0,1,0,-1} ;
        int[] S5 = {0,0,1,1,0,-1} ;
        //T
        int[] T1 = {0,1,1,1,0,-1} ;
        int[] T2 = {0,0,1,0,0,-1} ;
        int[] T3 = {0,0,1,0,0,-1} ;
        int[] T4 = {0,0,1,0,0,-1} ;
        int[] T5 = {0,0,1,0,0,-1} ;
        //U
        int[] U1 = {0,1,0,1,0,-1} ;
        int[] U2 = {0,1,0,1,0,-1} ;
        int[] U3 = {0,1,0,1,0,-1} ;
        int[] U4 = {0,1,0,1,0,-1} ;
        int[] U5 = {0,1,1,1,0,-1} ;
        //V
        int[] V1 = {0,1,0,1,0,-1} ;
        int[] V2 = {0,1,0,1,0,-1} ;
        int[] V3 = {0,1,0,1,0,-1} ;
        int[] V4 = {0,1,0,1,0,-1} ;
        int[] V5 = {0,0,1,0,0,-1} ;
        //W
        int[] W1 = {1,0,0,0,1,-1} ;
        int[] W2 = {1,0,1,0,1,-1} ;
        int[] W3 = {1,0,1,0,1,-1} ;
        int[] W4 = {1,0,1,0,1,-1} ;
        int[] W5 = {1,1,0,1,1,-1} ;
        //X
        int[] X1 = {0,1,0,1,0,-1} ;
        int[] X2 = {0,1,0,1,0,-1} ;
        int[] X3 = {0,0,1,0,0,-1} ;
        int[] X4 = {0,1,0,1,0,-1} ;
        int[] X5 = {0,1,0,1,0,-1} ;
        //Y
        int[] Y1 = {0,1,0,1,0,-1} ;
        int[] Y2 = {0,1,0,1,0,-1} ;
        int[] Y3 = {0,1,0,1,0,-1} ;
        int[] Y4 = {0,0,1,0,0,-1} ;
        int[] Y5 = {0,0,1,0,0,-1} ;
        //Z
        int[] Z1 = {0,1,1,1,0,-1} ;
        int[] Z2 = {0,0,0,1,0,-1} ;
        int[] Z3 = {0,0,1,0,0,-1} ;
        int[] Z4 = {0,1,0,0,0,-1} ;
        int[] Z5 = {0,1,1,1,0,-1} ;
        //.
        int[] PE1 = {0,0,0,0,0,-1} ;
        int[] PE2 = {0,0,0,0,0,-1} ;
        int[] PE3 = {0,0,0,0,0,-1} ;
        int[] PE4 = {0,0,0,0,0,-1} ;
        int[] PE5 = {0,0,1,0,0,-1} ;
        //!
        int[] EP1 = {0,0,1,0,0,-1} ;
        int[] EP2 = {0,0,1,0,0,-1} ;
        int[] EP3 = {0,0,1,0,0,-1} ;
        int[] EP4 = {0,0,0,0,0,-1} ;
        int[] EP5 = {0,0,1,0,0,-1} ;
        //?
        int[] QM1 = {0,1,1,0,0,-1} ;
        int[] QM2 = {0,0,1,0,0,-1} ;
        int[] QM3 = {0,0,1,0,0,-1} ;
        int[] QM4 = {0,0,0,0,0,-1} ;
        int[] QM5 = {0,0,1,0,0,-1} ;
        //1
        int[] ONE1 = {0,1,1,0,0,-1} ;
        int[] ONE2 = {0,0,1,0,0,-1} ;
        int[] ONE3 = {0,0,1,0,0,-1} ;
        int[] ONE4 = {0,0,1,0,0,-1} ;
        int[] ONE5 = {0,1,1,1,0,-1} ;
        //2
        int[] TWO1 = {0,0,1,1,0,-1} ;
        int[] TWO2 = {0,1,0,0,1,-1} ;
        int[] TWO3 = {0,0,0,1,0,-1} ;
        int[] TWO4 = {0,0,1,0,0,-1} ;
        int[] TWO5 = {0,1,1,1,1,-1} ;
        //3
        int[] THREE1 = {0,0,1,1,0,-1} ;
        int[] THREE2 = {0,1,0,0,1,-1} ;
        int[] THREE3 = {0,0,0,1,1,-1} ;
        int[] THREE4 = {0,1,0,0,1,-1} ;
        int[] THREE5 = {0,0,1,1,0,-1} ;
        //4
        int[] FOUR1 = {0,1,0,1,0,-1} ;
        int[] FOUR2 = {0,1,0,1,0,-1} ;
        int[] FOUR3 = {0,1,1,1,0,-1} ;
        int[] FOUR4 = {0,0,0,1,0,-1} ;
        int[] FOUR5 = {0,0,0,1,0,-1} ;
        //5
        int[] FIVE1 = {0,1,1,1,0,-1} ;
        int[] FIVE2 = {0,1,0,0,0,-1} ;
        int[] FIVE3 = {0,1,1,1,0,-1} ;
        int[] FIVE4 = {0,0,0,1,0,-1} ;
        int[] FIVE5 = {0,1,1,1,0,-1} ;
        //6
        int[] SIX1 = {0,1,1,1,0,-1} ;
        int[] SIX2 = {0,1,0,0,0,-1} ;
        int[] SIX3 = {0,1,1,1,0,-1} ;
        int[] SIX4 = {0,1,0,1,0,-1} ;
        int[] SIX5 = {0,1,1,1,0,-1} ;
        //7
        int[] SEVEN1 = {0,1,1,1,1,-1} ;
        int[] SEVEN2 = {0,0,0,0,1,-1} ;
        int[] SEVEN3 = {0,0,0,1,0,-1} ;
        int[] SEVEN4 = {0,0,1,0,0,-1} ;
        int[] SEVEN5 = {0,1,0,0,0,-1} ;
        //8
        int[] EIGHT1 = {0,1,1,1,0,-1} ;
        int[] EIGHT2 = {0,1,0,1,0,-1} ;
        int[] EIGHT3 = {0,1,1,1,0,-1} ;
        int[] EIGHT4 = {0,1,0,1,0,-1} ;
        int[] EIGHT5 = {0,1,1,1,0,-1} ;
        //9
        int[] NINE1 = {0,1,1,1,0,-1} ;
        int[] NINE2 = {0,1,0,1,0,-1} ;
        int[] NINE3 = {0,1,1,1,0,-1} ;
        int[] NINE4 = {0,0,0,1,0,-1} ;
        int[] NINE5 = {0,1,1,1,0,-1} ;
        //0
        int[] ZERO1 = {0,0,1,1,0,-1} ;
        int[] ZERO2 = {0,1,0,0,1,-1} ;
        int[] ZERO3 = {0,1,0,0,1,-1} ;
        int[] ZERO4 = {0,1,0,0,1,-1} ;
        int[] ZERO5 = {0,0,1,1,0,-1} ;
        //&
        int[] AMPERSAND1 = {0,1,1,1,1,-1} ;
        int[] AMPERSAND2 = {0,1,1,1,1,-1} ;
        int[] AMPERSAND3 = {0,1,1,1,1,-1} ;
        int[] AMPERSAND4 = {0,1,1,1,1,-1} ;
        int[] AMPERSAND5 = {0,1,1,1,1,-1} ;

        switch (c) {
            case 'A':
            case 'a':
                dotline(A1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(A2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(A3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(A4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(A5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'B':
            case 'b':
                dotline(B1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(B2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(B3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(B4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(B5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'C':
            case 'c':
                dotline(C1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(C2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(C3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(C4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(C5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'D':
            case 'd':
                dotline(D1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(D2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(D3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(D4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(D5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'E':
            case 'e':
                dotline(E1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(E2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(E3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(E4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(E5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'F':
            case 'f':
                dotline(F1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(F2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(F3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(F4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(F5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'G':
            case 'g':
                dotline(G1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(G2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(G3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(G4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(G5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'H':
            case 'h':
                dotline(H1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(H2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(H3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(H4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(H5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'I':
            case 'i':
                dotline(I1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(I2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(I3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(I4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(I5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'J':
            case 'j':
                dotline(J1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(J2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(J3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(J4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(J5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'K':
            case 'k':
                dotline(K1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(K2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(K3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(K4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(K5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'L':
            case 'l':
                dotline(L1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(L2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(L3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(L4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(L5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'M':
            case 'm':
                dotline(M1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(M2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(M3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(M4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(M5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'N':
            case 'n':
                dotline(N1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(N2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(N3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(N4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(N5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'O':
            case 'o':
                dotline(O1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(O2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(O3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(O4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(O5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'P':
            case 'p':
                dotline(P1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(P2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(P3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(P4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(P5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'Q':
            case 'q':
                dotline(Q1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(Q2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(Q3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(Q4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(Q5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'R':
            case 'r':
                dotline(R1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(R2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(R3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(R4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(R5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'S':
            case 's':
                dotline(S1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(S2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(S3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(S4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(S5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'T':
            case 't':
                dotline(T1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(T2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(T3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(T4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(T5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'U':
            case 'u':
                dotline(U1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(U2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(U3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(U4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(U5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'V':
            case 'v':
                dotline(V1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(V2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(V3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(V4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(V5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'W':
            case 'w':
                dotline(W1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(W2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(W3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(W4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(W5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'X':
            case 'x':
                dotline(X1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(X2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(X3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(X4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(X5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'Y':
            case 'y':
                dotline(Y1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(Y2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(Y3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(Y4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(Y5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case 'Z':
            case 'z':
                dotline(Z1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(Z2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(Z3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(Z4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(Z5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '.':
                dotline(PE1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(PE2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(PE3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(PE4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(PE5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '!':
                dotline(EP1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(EP2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(EP3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(EP4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(EP5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '?':
                dotline(QM1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(QM2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(QM3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(QM4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(QM5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '1':
                dotline(ONE1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(ONE2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(ONE3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(ONE4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(ONE5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '2':
                dotline(TWO1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(TWO2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(TWO3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(TWO4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(TWO5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '3':
                dotline(THREE1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(THREE2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(THREE3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(THREE4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(THREE5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '4':
                dotline(FOUR1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(FOUR2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(FOUR3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(FOUR4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(FOUR5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '5':
                dotline(FIVE1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(FIVE2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(FIVE3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(FIVE4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(FIVE5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '6':
                dotline(SIX1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(SIX2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(SIX3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(SIX4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(SIX5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '7':
                dotline(SEVEN1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(SEVEN2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(SEVEN3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(SEVEN4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(SEVEN5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '8':
                dotline(EIGHT1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(EIGHT2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(EIGHT3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(EIGHT4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(EIGHT5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '9':
                dotline(NINE1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(NINE2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(NINE3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(NINE4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(NINE5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '0':
                dotline(ZERO1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(ZERO2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(ZERO3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(ZERO4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(ZERO5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            case '&':
                dotline(AMPERSAND1,x,(y + (4 * size)),size,red,green,blue) ;
                dotline(AMPERSAND2,x,(y + (3 * size)),size,red,green,blue) ;
                dotline(AMPERSAND3,x,(y + (2 * size)),size,red,green,blue) ;
                dotline(AMPERSAND4,x,(y + (1 * size)),size,red,green,blue) ;
                dotline(AMPERSAND5,x,(y + (0 * size)),size,red,green,blue) ;
                break;
            default:
                break;
        }
    }


    @Override
    public void draw() {
       int i = 0;
       byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
       while (i < bytes.length) {
           drawChar(bytes[i],size,posX + (i * (size * 5)),posY,red,green,blue);
           i++;
       }
    }

    @Override
    public void updateBoundingBox() {
        boundingBox.update(posX,posX + (text.getBytes(StandardCharsets.UTF_8).length * (size * 5)),posY,posY + (4 * size));
    }
}
