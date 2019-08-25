package net.runelite.runeloader.inject;

import java.util.LinkedList;
import java.util.List;

public class InjectionModscript
{
	private int revision;
	private List<GetterInjectInstruction> getterInjects = new LinkedList<>();
	private List superChangeInjects = new LinkedList();
	private List<AddInterfaceInstruction> addInterfaceInjects = new LinkedList<>();
	private List methodMods = new LinkedList();
	private List addMethods = new LinkedList();
	private List instructionReplacements = new LinkedList();
	private List newMethodMods = new LinkedList();
	private List newFields = new LinkedList();

	public int getRevision()
	{
		return revision;
	}

	public List<GetterInjectInstruction> getGetterInjects()
	{
		return this.getterInjects;
	}

	public List getSuperChangeInjects()
	{
		return this.superChangeInjects;
	}

	public List<AddInterfaceInstruction> getAddInterfaceInjects()
	{
		return this.addInterfaceInjects;
	}

	public List getMethodMods()
	{
		return this.methodMods;
	}

	public List getAddMethods()
	{
		return this.addMethods;
	}

	public List getNewMethodMods()
	{
		return this.newMethodMods;
	}

	public List getInstructionReplacements()
	{
		return this.instructionReplacements;
	}

	public List getNewFields()
	{
		return this.newFields;
	}
}
