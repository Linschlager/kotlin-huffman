# kotlin-huffman
Huffman encoding implemented in Kotlin.
You can find the executable JAR-file [here](/artifacts/kotlin-huffman.jar)

***Disclaimer: This is a purely educational project and should not be used in a production environment***

### CLI Usage
| Parameter | Type | Description | Format |
| --- | --- | --- | --- |
| `--file` | String | Path to input file | file containing encoded data or text
| `--ht-file` | String | Path to huffman tree | &lt;ASCII&gt;:&lt;Huffman&gt;, Delimiter: -
| `--out` | String | Path to output file | encoded data or decoded text
| `--ht-out` | String | Path to huffman output file | &lt;ASCII&gt;:&lt;Huffman&gt;, Delimiter: -
| `--encode` | Switch | Flag to encode the input file generating a custom huffman tree |
| `--decode` | Switch | Flag to decrypt the input file using the given huffman tree |

*Currently, the program does not overwrite any existing files but rather throw an error and abort*

### Example usage
```bash
java -jar kotlin-huffman.jar --file=input/output-mada.dat --ht-file=input/dec_tab-mada.txt --decode

java -jar kotlin-huffman.jar --file=input/sample-text.txt --ht-out=out/dec_tab-mada.txt --out=out/output-mada.dat --encode 
```
