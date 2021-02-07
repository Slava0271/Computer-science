package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment15;

/**
 * The class in which the work with parameters takes
 * place, on the basis of which the program decides
 * whether it needs to be archived or unzipped
 */
public class ReadParameters {
    //default file name
    private static final String DEFAULT_FILE_NAME = "test.txt";

    //variables with filenames

    private String inputFile;
    private String outputFile;

    /**
     * @return - get input file
     */
    public String getInputFile() {
        return inputFile;
    }

    /**
     * @return - get output file
     */
    public String getOutputFile() {
        return outputFile;
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
    public int readParameters(String[] args) throws Exception {
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
     * Check if the string ends with characters of par,
     * if so, return the value true
     *
     * @param string - input string
     * @return - true or false
     */
    private boolean isPar(String string) {
        return string.charAt(string.length() - 3) == 'p' && string.charAt(string.length() - 2) ==
                'a' && string.charAt(string.length() - 1) == 'r';
    }
}
