import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import tinyprinter.gen.tinyBaseListener;
import tinyprinter.gen.tinyParser;

public class TinyPrintListener extends tinyBaseListener {
    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();
    private String result = "";

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(tinyParser.ProgramContext ctx) {
        //program
        //   : 'BEGIN' stmt_list 'END'
        //   ;
        result += ctx.getChild(0)+"\n";
        result += newTexts.get(ctx.stmt_list());
        result += ctx.getChild(2)+"\n";

        System.out.println(result);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt_list(tinyParser.Stmt_listContext ctx) {
        //stmt_list
        //   : stmt_list stmt
        //   | stmt
        //   ;
        if (ctx.getChildCount() == 2){
            newTexts.put(ctx, newTexts.get(ctx.stmt_list()) + newTexts.get(ctx.stmt()) + "\n");
        } else {
            newTexts.put(ctx,  newTexts.get(ctx.stmt()) + "\n");
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt(tinyParser.StmtContext ctx) {
        //stmt
        //   : assign_stmt
        //   | read_stmt
        //   | write_stmt
        //   ;
        if (ctx.getChild(0) == ctx.assign_stmt()){
            newTexts.put(ctx, newTexts.get(ctx.assign_stmt()));
        } else if (ctx.getChild(0) == ctx.read_stmt()){
            newTexts.put(ctx, newTexts.get(ctx.read_stmt()));
        } else {
            newTexts.put(ctx, newTexts.get(ctx.write_stmt()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssign_stmt(tinyParser.Assign_stmtContext ctx) {
        //assign_stmt
        //   : ident ':=' expr
        //   ;
        newTexts.put(ctx, newTexts.get(ctx.ident())+" := "+newTexts.get(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRead_stmt(tinyParser.Read_stmtContext ctx) {
        //read_stmt
        //   : 'READ' id_list
        //   ;
        newTexts.put(ctx, "READ "+newTexts.get(ctx.id_list()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWrite_stmt(tinyParser.Write_stmtContext ctx) {
        // write_stmt
        //   : 'WRITE' expr_list
        //   ;
        newTexts.put(ctx,   "WRITE " + newTexts.get(ctx.expr_list()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitId_list(tinyParser.Id_listContext ctx) {
        //id_list
        //   : id_list ',' ident
        //   | ident
        //   ;
        if (ctx.getChildCount() == 3){
            newTexts.put(ctx, newTexts.get(ctx.id_list())+", "+newTexts.get(ctx.ident()));
        } else {
            newTexts.put(ctx, newTexts.get(ctx.ident()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list(tinyParser.Expr_listContext ctx) {
        //expr_list
        //   : expr_list ',' expr
        //   | expr
        //   ;
        if (ctx.getChildCount() == 3){
            newTexts.put(ctx, newTexts.get(ctx.expr_list())+", "+ctx.expr());
        } else {
            newTexts.put(ctx, newTexts.get(ctx.expr()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(tinyParser.ExprContext ctx) {
        //expr
        //   : expr op factor
        //   | factor
        //   ;
        if (ctx.getChildCount() == 3){
            newTexts.put(ctx, newTexts.get(ctx.expr())+" "+newTexts.get(ctx.op())+" "+newTexts.get(ctx.factor()));
        } else {
            newTexts.put(ctx, newTexts.get(ctx.factor()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFactor(tinyParser.FactorContext ctx) {
        //factor
        //   : ident
        //   | integer
        //   ;
        if (ctx.getChild(0) == ctx.ident()){
            newTexts.put(ctx, newTexts.get(ctx.ident()));
        } else {
            newTexts.put(ctx, newTexts.get(ctx.integer()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInteger(tinyParser.IntegerContext ctx) {
        //integer
        //   : '-'? NUMBER
        //   ;
        newTexts.put(ctx, ctx.getChild(0).getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOp(tinyParser.OpContext ctx) {
        //op
        //   : '+'
        //   | '-'
        //   ;
        newTexts.put(ctx, ctx.getChild(0).getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdent(tinyParser.IdentContext ctx) {
        //ident
        //   : ID
        //   ;
        newTexts.put(ctx, ctx.getChild(0).getText());
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}
