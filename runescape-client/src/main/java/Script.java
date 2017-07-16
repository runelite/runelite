import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field1530;
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "Lbe;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("j")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("n")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1613300093
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1673906801
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("r")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1732810093
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 269316271
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   @Export("switches")
   class186[] switches;

   static {
      field1530 = new NodeCache(128);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)[Lgl;",
      garbageValue = "68"
   )
   class186[] method1837(int var1) {
      return new class186[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILhx;I)I",
      garbageValue = "-1532471377"
   )
   public static int method1835(int var0, class219 var1) {
      return (var0 + '鱀' << 8) + var1.field2801;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-337634088"
   )
   static final void method1831(String var0) {
      if(var0 != null) {
         String var1 = class202.method3682(var0, class164.field2317);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class202.method3682(var4, class164.field2317);
               if(class46.method713(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field1099 = Client.field1045;
                  Client.secretPacketBuffer1.putOpcode(192);
                  Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }
}
