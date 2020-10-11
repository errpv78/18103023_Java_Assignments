class q1
{
    public static void main(String[] args)
    {
        int num = -1;
        byte b = (byte)num;
        int n = b;
        char c = (char)b, c1 = (char)n;
        int final_num = c;
        System.out.println("Initial integer: "+ num); // -1
        System.out.println("Byte: "+ b + " " + n + " " + c1); // -1
        System.out.println("Character: "+ c); // a rectangle char
        System.out.println("Final integer: "+ final_num); // 65535
    }
}

// Explanation:
// 1. Int to byte: byte in java is signed. So it has range
// -2^7 to 2^7 +1. Thus -1 remains -1. If something out of range
// would be there then 2^8 is added or subtracted until it falls
// into range. For ex for int -255, it shows 1, after adding 2^8
// ie -255 + 256 = 1.

// 2. Byte to char: The byte is first converted to int and then
// int is converted to char.

// 3. char to int: int is 32 bits. char is 16. therefore the
// result is 2^16 - value of char