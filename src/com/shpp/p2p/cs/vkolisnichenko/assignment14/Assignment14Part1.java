package com.shpp.p2p.cs.vkolisnichenko.assignment14;

import java.io.File;

/**
 * A class in which, depending on the parameters,
 * we determine the operation that we need to
 * perform and execute it, we also write information
 * about the actions performed to the console
 */
public class Assignment14Part1 {
    //The constant that stores the default file name
    private static final String DEFAULT_FILE_NAME = "test.txt";
    //Create variables that will store file names
    private static String inputFile, outputFile;

    /**
     * The method in which we create objects of
     * classes for archiving and unzipping and
     * perform the desired operation, after which
     * we output information to the console
     *
     * @param args - program arguments
     * @throws Exception - method can throw Exception
     */
    public static void main(String[] args) throws Exception {
        //Get the start time of the program
        long timeMillis = System.currentTimeMillis();

        //We get the operation that we need to perform
        int getOperation = readParameters(args);
        //Creating class objects
        Archive archive = new Archive(inputFile, outputFile);
        UnArchive unArchive = new UnArchive(outputFile, inputFile);

        //Depending on the variable, perform the desired operation
        if (getOperation == 1) {
            archive.writeToFile();
        } else if (getOperation == 2) {
            unArchive.unArchiveFile();
        }
        //We receive information about the implementation
        getInformation(getOperation, timeMillis);

    }

    /**
     * The method in which we output information about
     * the execution of the program to the console:
     * file size, execution time and efficiency
     *
     * @param operation  - get operation( archive or unarchive)
     * @param timeMillis - get start program time
     */
    private static void getInformation(int operation, long timeMillis) {
        if (operation == 1) {
            if (isInputFileLarger())
                System.out.println("Archiving was efficient");
            else System.out.println("Archiving was ineffective");
        } else if (operation == 2) {
            if (!isInputFileLarger())
                System.out.println("Archiving was ineffective");
            else System.out.println("Archiving was efficient");
        }
        System.out.println("execution time - " + (double)
                (System.currentTimeMillis() - timeMillis) / 1000 + " Seconds");
        if (operation == 1) {
            System.out.println("inputFile : " + getFileSizeBytes(new File(inputFile)) + " bytes");
            System.out.println("outputFile : " + getFileSizeBytes(new File(outputFile)) + " bytes");
        } else if (operation == 2) {
            System.out.println("inputFile : " + getFileSizeBytes(new File(outputFile)) + " bytes");
            System.out.println("outputFile : " + getFileSizeBytes(new File(inputFile)) + " bytes");
        }

    }

    /**
     * The method in which we read the parameters and,
     * depending on the entered parameters, we return
     * the operation that we need to do (archiving or unarchiving)
     *
     * @param args - program arguments
     * @return - operation
     * @throws Exception - method can throw Exception
     */
    private static int readParameters(String[] args) throws Exception {
        if (args.length == 0) {
            inputFile = DEFAULT_FILE_NAME;
            outputFile = "test.par";
            return 1;
        } else if (args.length == 1) {
            if (!isPar(args[0])) {
                inputFile = args[0];
                outputFile = args[0] + ".par";
                return 1;
            } else if (isPar(args[0])) {
                outputFile = args[0];
                inputFile = args[0].substring(0, args[0].length() - 4);
                return 2;
            }
        } else if (args.length == 2) {
            if (isPar(args[0])) {
                outputFile = args[0];
                inputFile = args[1];
                return 2;
            } else if (isPar(args[1])) {
                outputFile = args[1];
                inputFile = args[0];
                return 1;
            }
        } else if (args.length == 3) {
            if (args[0].equals("-a")) {
                inputFile = args[1];
                outputFile = args[2];
                return 1;
            } else if (args[0].equals("-u")) {
                inputFile = args[2];
                outputFile = args[1];
                return 2;
            } else throw new Exception("You entered incorrect parameters");
        } else
            throw new Exception("You entered incorrect parameters");
        return 0;
    }

    /**
     * Check if the input file is greater than
     * the output and return a boolean value
     *
     * @return - true or false
     */
    private static boolean isInputFileLarger() {
        return getFileSizeBytes(new File(inputFile)) >= getFileSizeBytes(new File(outputFile));
    }

    /**
     * Check if the string ends with characters of par,
     * if so, return the value true
     *
     * @param string - input string
     * @return - true or false
     */
    private static boolean isPar(String string) {
        return string.charAt(string.length() - 3) == 'p' && string.charAt(string.length() - 2) ==
                'a' && string.charAt(string.length() - 1) == 'r';
    }

    /**
     * The method in which we get the size of the input file
     *
     * @param file - input file
     * @return - size
     */
    private static long getFileSizeBytes(File file) {
        return file.length();
    }

}
