// Generated from /Users/hyungjin/IdeaProjects/compiler.hw01/tiny/tiny.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tinyParser}.
 */
public interface tinyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tinyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tinyParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tinyParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(tinyParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(tinyParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(tinyParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(tinyParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(tinyParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(tinyParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(tinyParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(tinyParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(tinyParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(tinyParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(tinyParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(tinyParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(tinyParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(tinyParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(tinyParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(tinyParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(tinyParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(tinyParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(tinyParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(tinyParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(tinyParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(tinyParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link tinyParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(tinyParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link tinyParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(tinyParser.IdentContext ctx);
}