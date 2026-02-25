package dev.amerida.algoritms.leed_code.string_decoder;

public class StringDecoder {

    public String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();

        char[] chars = encoded.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '.' -> decoded.append(0);
                case '-' -> {
                    if (chars[i+1] == '-') {
                        decoded.append(2);
                    } else {
                        decoded.append(1);
                    }
                    i++;
                }
                default -> throw new IllegalArgumentException("Invalid encoded string");
            }
        }

        return decoded.toString();
    }

    public String decodeClever(String encoded) {
        if (encoded == null || encoded.isEmpty()) return "";

        StringBuilder decodedString = new StringBuilder();

        // The -1 limit ensures trailing empty strings aren't discarded by split()
        String[] parts = encoded.split("\\.", -1);

        for (String part : parts) {
            decodedString.append(part.length());
        }

        return decodedString.toString();
    }
}
