import java.util.ArrayList;
import java.util.Scanner;

//Created by RakNoel, 11.11.2016.
public class falseSecurity {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scn = new Scanner(System.in);

        while(true) {
            String kodeStart = scn.nextLine().toUpperCase();
            int[] encryptionLine = new int[kodeStart.length()];
            String encrypted = "";

            int i = 0;
            for (char a : kodeStart.toCharArray()) {
                switch (a) {
                    case 'A': encrypted += ".-"; encryptionLine[i] = 2; break;
                    case 'B': encrypted += "-..."; encryptionLine[i] = 4; break;
                    case 'C': encrypted += "-.-."; encryptionLine[i] = 4; break;
                    case 'D': encrypted += "-.."; encryptionLine[i] = 3; break;
                    case 'E': encrypted += "."; encryptionLine[i] = 1; break;
                    case 'F': encrypted += "..-."; encryptionLine[i] = 4; break;
                    case 'G': encrypted += "--."; encryptionLine[i] = 3; break;
                    case 'H': encrypted += "...."; encryptionLine[i] = 4; break;
                    case 'I': encrypted += ".."; encryptionLine[i] = 2; break;
                    case 'J': encrypted += ".---"; encryptionLine[i] = 4; break;
                    case 'K': encrypted += "-.-"; encryptionLine[i] = 3; break;
                    case 'L': encrypted += ".-.."; encryptionLine[i] = 4; break;
                    case 'M': encrypted += "--"; encryptionLine[i] = 2; break;
                    case 'N': encrypted += "-."; encryptionLine[i] = 2; break;
                    case 'O': encrypted += "---"; encryptionLine[i] = 3; break;
                    case 'P': encrypted += ".--."; encryptionLine[i] = 4; break;
                    case 'Q': encrypted += "--.-"; encryptionLine[i] = 4; break;
                    case 'R': encrypted += ".-."; encryptionLine[i] = 3; break;
                    case 'S': encrypted += "..."; encryptionLine[i] = 3; break;
                    case 'T': encrypted += "-"; encryptionLine[i] = 1; break;
                    case 'U': encrypted += "..-"; encryptionLine[i] = 3; break;
                    case 'V': encrypted += "...-"; encryptionLine[i] = 4; break;
                    case 'W': encrypted += ".--"; encryptionLine[i] = 3; break;
                    case 'X': encrypted += "-..-"; encryptionLine[i] = 4; break;
                    case 'Y': encrypted += "-.--"; encryptionLine[i] = 4; break;
                    case 'Z': encrypted += "--.."; encryptionLine[i] = 4; break;
                    case '_': encrypted += "..--"; encryptionLine[i] = 4; break;
                    case ',': encrypted += ".-.-"; encryptionLine[i] = 4; break;
                    case '.': encrypted += "---."; encryptionLine[i] = 4; break;
                    case '?': encrypted += "----"; encryptionLine[i] = 4; break;
                }

                i++;
            }

            String decoded = "";
            int sequenceCounter = 0;
            for (int x = encryptionLine.length - 1; x >= 0; x--) {
                decoded +=
                        MorseTilBokstav((String)
                                encrypted.subSequence(
                                        sequenceCounter, sequenceCounter + encryptionLine[x]
                                )
                        );

                sequenceCounter += encryptionLine[x];
            }

            System.out.println(decoded);
        }
    }

    public static char MorseTilBokstav(String Morse) throws IllegalArgumentException {
        switch (Morse) {
            case ".-": return 'A';
            case "-...": return 'B';
            case "-.-.": return 'C';
            case "-..": return 'D';
            case ".": return 'E';
            case "..-.": return 'F';
            case "--.": return 'G';
            case "....": return 'H';
            case "..": return 'I';
            case ".---": return 'J';
            case "-.-": return 'K';
            case ".-..": return 'L';
            case "--": return 'M';
            case "-.": return 'N';
            case "---": return 'O';
            case ".--.": return 'P';
            case "--.-": return 'Q';
            case ".-.": return 'R';
            case "...": return 'S';
            case "-": return 'T';
            case "..-": return 'U';
            case "...-": return 'V';
            case ".--": return 'W';
            case "-..-": return 'X';
            case "-.--": return 'Y';
            case "--..": return 'Z';
            case "..--": return '_';
            case ".-.-": return ',';
            case "---.": return '.';
            case "----": return '?';
            default:
                throw new IllegalArgumentException("Case " + Morse + " was not found!");
        }
    }

}
