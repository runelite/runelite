package net.runelite.cache.definitions;

import net.runelite.cache.io.InputStream;


/**
 * Created by Allen Kinzalow on 3/14/2015.
 */
public abstract class Definition {

    int definitionID;

    public Definition(int definitionID) {
        this.definitionID = definitionID;
    }

    //abstract OutputStream encode(OutputStream stream);

    public void decode(InputStream stream) {
        while(true) {
            int opcode = stream.readUnsignedByte();
            if(opcode == 0) {
                return;
            }

            this.decodeValues(opcode, stream);
        }
    }

    abstract void decodeValues(int opcode, InputStream stream);

    //public abstract void printDefinition();

    public int getDefinitionID() {
        return this.definitionID;
    }

}
