import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tinyprinter.gen.tinyLexer;
import tinyprinter.gen.tinyParser;

import java.io.IOException;

public class TinyMain {
    public static void main(String[] args) throws IOException {
        String filename = "./tiny/examples/example3.txt";
        tinyLexer lexer = new tinyLexer(new ANTLRFileStream(filename));
        tinyParser parser = new tinyParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new TinyPrintListener(), tree);
    }
}
