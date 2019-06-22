import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Script")
public class Script extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("Script_cached")
   static EvictingDualNodeHashTable Script_cached;
   @ObfuscatedName("f")
   @Export("opcodes")
   int[] opcodes;
   @ObfuscatedName("q")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("w")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1952727759
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1124477681
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1077473933
   )
   @Export("intArgumentCount")
   int intArgumentCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -503680987
   )
   @Export("stringArgumentCount")
   int stringArgumentCount;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("switches")
   IterableNodeHashTable[] switches;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[Llh;",
      garbageValue = "-729647116"
   )
   @Export("__o_164")
   IterableNodeHashTable[] __o_164(int var1) {
      return new IterableNodeHashTable[var1];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   static void method2216(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.remove();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "992185550"
   )
   static final int method2204(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = method2214(var3, var5);
      int var8 = method2214(var3 + 1, var5);
      int var9 = method2214(var3, var5 + 1);
      int var10 = method2214(var3 + 1, var5 + 1);
      int var11 = GraphicsObject.method1986(var7, var8, var4, var2);
      int var12 = GraphicsObject.method1986(var9, var10, var4, var2);
      return GraphicsObject.method1986(var11, var12, var6, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "445983180"
   )
   static final int method2214(int var0, int var1) {
      int var2 = class236.method4537(var0 - 1, var1 - 1) + class236.method4537(var0 + 1, var1 - 1) + class236.method4537(var0 - 1, 1 + var1) + class236.method4537(var0 + 1, var1 + 1);
      int var3 = class236.method4537(var0 - 1, var1) + class236.method4537(var0 + 1, var1) + class236.method4537(var0, var1 - 1) + class236.method4537(var0, 1 + var1);
      int var4 = class236.method4537(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(Ljh;IIII)V",
      garbageValue = "-1584807244"
   )
   static void method2201(SequenceDefinition var0, int var1, int var2, int var3) {
      if(Client.soundEffectCount < 50 && Client.__client_qc != 0 && var0.__e != null && var1 < var0.__e.length) {
         int var4 = var0.__e[var1];
         if(var4 != 0) {
            int var5 = var4 >> 8;
            int var6 = var4 >> 4 & 7;
            int var7 = var4 & 15;
            Client.soundEffectIds[Client.soundEffectCount] = var5;
            Client.unknownSoundValues1[Client.soundEffectCount] = var6;
            Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
            Client.soundEffects[Client.soundEffectCount] = null;
            int var8 = (var2 - 64) / 128;
            int var9 = (var3 - 64) / 128;
            Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
            ++Client.soundEffectCount;
         }
      }

   }

   static {
      Script_cached = new EvictingDualNodeHashTable(128);
   }
}
