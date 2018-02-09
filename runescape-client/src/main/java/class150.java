import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class150 implements class149 {
   @ObfuscatedName("i")
   static File field2091;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_reference")
   static Buffer NetCache_reference;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1198470794"
   )
   static int method3167() {
      return ++class94.field1414 - 1;
   }
}
