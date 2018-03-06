package bayesiannetwork;

// Generated from bayesian.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Pars}.
 */
public interface bayesianListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Pars#evidenceVariable}.
	 * @param ctx the parse tree
	 */
	void enterEvidenceVariable(@NotNull Pars.EvidenceVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Pars#evidenceVariable}.
	 * @param ctx the parse tree
	 */
	void exitEvidenceVariable(@NotNull Pars.EvidenceVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Pars#queryVariable}.
	 * @param ctx the parse tree
	 */
	void enterQueryVariable(@NotNull Pars.QueryVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Pars#queryVariable}.
	 * @param ctx the parse tree
	 */
	void exitQueryVariable(@NotNull Pars.QueryVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Pars#bayes}.
	 * @param ctx the parse tree
	 */
	void enterBayes(@NotNull Pars.BayesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Pars#bayes}.
	 * @param ctx the parse tree
	 */
	void exitBayes(@NotNull Pars.BayesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Pars#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull Pars.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Pars#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull Pars.FactorContext ctx);
}