package net.runelite.client.plugins.chatcommands;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * A simple BEDMAS calculator used in {@link ChatCommandsPlugin}.
 * As of now, expects "nicely behaved" equations, or it will throw exceptions. It is handled externally in {@link ChatCommandsPlugin}.
 *
 * Will add specific error checking in the future, but since this is a simple calculator, it's unnecessary.
 *
 * @author IronApeiron
 *         Date Created: 2018-06-25
 */
public class Calculator 
{


	enum Operator
	{
		ADDITION("+", 2, Associativity.LEFT, (x, y) -> x + y), SUBTRACTION("-", 1, Associativity.LEFT, (x, y) -> x - y),
		MULTIPLICATION("*", 3, Associativity.LEFT, (x, y) -> x * y), DIVISION("/", 4, Associativity.LEFT, (x, y) -> x / y),
		EXPONENTIATION("^", 5, Associativity.RIGHT, Math::pow), LEFT_BRACKET("(", 6, Associativity.NONE, null),
		RIGHT_BRACKET(")", 6, Associativity.NONE, null);

		enum Associativity
		{
			LEFT, RIGHT, NONE
		}

		String symbol;
		int precedence;
		Associativity associativity;
		BinaryOperator<Double> func;

		Operator (String symbol, int precedence, Associativity associativity, BinaryOperator<Double> func)
		{
			this.symbol = symbol;
			this.precedence = precedence;
			this.associativity = associativity;
			this.func = func;
		}

	}

	/**
	 * Evaluates an infix expression passed in as a {@link java.lang.String}. It is an expression containing sub-expressions with +, -, *, /, ^
	 * with integer or decimal operands (double). Spacing doesn't matter.
	 *
	 * Expects "nicely formatted" equations. Throws an error for any strange/unsupported symbols in eqn.
	 *
	 * @param eqn An infix expression.
	 * @return The evaluation of the infix expression.
	 */
	protected static double eval(String eqn) throws IllegalFormatException
	{
		return evalRevPolish(toRevPolishNotation(eqn));
	}

	/**
	 * Takes a Queue with tokens representing an equation in reverse polish notation.
	 *
	 * @param revPolishEqn An equation to be evaluated in reverse polish notation represented by tokens in a queue.
	 * @return The evaluation of the expression.
	 */
	protected static double evalRevPolish(Queue<Object> revPolishEqn)
	{
		double d1, d2;

		Stack<Double> operandStack = new Stack<>();

		for (Object expr : revPolishEqn)
		{
			if (expr instanceof Operator)
			{
				Operator op = (Operator) expr;

				if(op == Operator.ADDITION || op == Operator.MULTIPLICATION) 
				{
					d1 = operandStack.pop();
					d2 = operandStack.pop();
				}
				else
				{
					d2 = operandStack.pop();
					d1 = operandStack.pop();
				}


				operandStack.add(op.func.apply(d1, d2));


			}
			else if(expr instanceof Double)
			{
				operandStack.add((Double) expr);
			}
		}

		return operandStack.pop();
	}

	/**
	 * Uses the Shunting Yard algorithm to convert an infix equation to a postfix equation stored in a queue (reverse
	 * polish notation).
	 *
	 * @param eqn The infix equation. It is an expression containing sub-expressions with +, -, *, /, ^
	 *            with integer or decimal operands (double). Spacing doesn't matter.
	 *
	 * @return The reverse polish notational equivalent to eqn.
	 */
	protected static Queue<Object> toRevPolishNotation(String eqn)
	{
		eqn = eqn.replaceAll("\\s+", "");
		String[] tokens = eqn.split("(?<=op)|(?=op)".replace("op", "[-+*^/()]"));

		Queue<Object> outputQueue = new LinkedList<>();
		Stack<Operator> opStack = new Stack<>();

		for (String token : tokens)
		{

			if(isNumeric(token))
			{
				outputQueue.offer(Double.parseDouble(token));
			}

			if(isFunction(token))
			{
				Operator op = getOp(token);

				while (!opStack.isEmpty() &&
						((opStack.peek().precedence > op.precedence || (opStack.peek().precedence == op.precedence && op.associativity == Operator.Associativity.LEFT))
								&& opStack.peek() != Operator.LEFT_BRACKET))
				{
					outputQueue.offer(opStack.pop());
				}

				opStack.push(op);
			}

			if (token.equals("("))
			{
				opStack.push(Operator.LEFT_BRACKET);
			}


			if (token.equals(")"))
			{
				while (!opStack.isEmpty() && opStack.peek() != Operator.LEFT_BRACKET)
				{
					outputQueue.offer(opStack.pop());
				}

				opStack.pop();
			}

		}

		while (!opStack.isEmpty())
		{
			outputQueue.offer(opStack.pop());
		}

		return outputQueue;
	}

	private static boolean isFunction(String op)
	{
		return Arrays.stream(Operator.values()).anyMatch(e -> e.symbol.equals(op)
				&& e != Operator.LEFT_BRACKET
				&& e != Operator.RIGHT_BRACKET);
	}

	private static Operator getOp(String op)
	{
		return Arrays.stream(Operator.values()).filter(e -> e.symbol.equals(op)).findFirst().orElseThrow(() -> new UnsupportedOperationException(String.format("Unsupported type %s.", op)));
	}

	private static boolean isNumeric(String s) 
	{
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}
