package IOStreams;

/**
 * Input/Output Streams process bytes.
 * But most of the application works with Text files or Characters.
 * Java uses unicode for characters :
 *      1) Unicode is a coding system than aims to encode;
 *          all the characters in the world in 21 bit code which is called "code point"
 *      2) Internally java do not use these 21 bit code points.
 *      3) Instead java uses 16 bit coding point points called UTF_16.
 *      4) Initially when java was designed Unicode in-fact only has 16 bit.
 *      5) Web Pages commonly use UTF_8.
 *      6) Files on desktop sometime use legacy encodings.
 *  Reader/Writers convert between bytes and characters.
 *  If we don't specify encoding while converting bytes than it will use the System's default encoding on which is programme is running.
 *  In order to read the correct values it is always recommended to specify Encoding while converting bytes to characters.
 */
public class CharacterEncoding {

    public static void main(String[] args) {
        String property = System.getProperty("file.encoding");
        System.out.println(property);
    }
}
