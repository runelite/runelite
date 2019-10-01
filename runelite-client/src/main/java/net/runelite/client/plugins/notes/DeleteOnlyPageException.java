package net.runelite.client.plugins.notes;

class DeleteOnlyPageException extends RuntimeException
{
	DeleteOnlyPageException()
	{
		super("Cannot delete the only page");
	}
}
