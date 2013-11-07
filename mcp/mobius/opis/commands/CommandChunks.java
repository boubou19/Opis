package mcp.mobius.opis.commands;

import java.util.ArrayList;

import mcp.mobius.opis.data.ChunkManager;
import mcp.mobius.opis.data.holders.ChunkStats;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandChunks extends CommandBase {

	@Override
	public String getCommandName() {
		return "opis_chunks";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		ArrayList<ChunkStats> chunks = new ArrayList<ChunkStats>();
		
		if (astring.length == 0)
			chunks = ChunkManager.getTopChunks(20);
		else
			try{
				chunks = ChunkManager.getTopChunks(Integer.valueOf(astring.length));	
			}catch (Exception e){return;}
		
		System.out.printf("== ==\n");
		for (ChunkStats stat : chunks){
			System.out.printf("%s\n", stat);
		}
		
	}

	@Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }	

	@Override
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
        return true;
    }	

}
