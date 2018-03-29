import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("c")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("i")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2113154709
   )
   int field783;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -788634243
   )
   int field778;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1822359363
   )
   int field791;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   Widget field784;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1358472503
   )
   @Export("pressedKey")
   int pressedKey;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1152280539
   )
   @Export("typedKey")
   int typedKey;
   @ObfuscatedName("r")
   @Export("string")
   String string;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1116840587
   )
   int field788;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   class245 field789;

   public ScriptEvent() {
      this.field789 = class245.field2958;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "-54"
   )
   public void method1102(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Liz;I)V",
      garbageValue = "-1705286435"
   )
   public void method1099(class245 var1) {
      this.field789 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljk;",
      garbageValue = "-113"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Llf;",
      garbageValue = "2026232087"
   )
   public static class320 method1103(int var0) {
      class320[] var1 = new class320[]{class320.field3932, class320.field3931, class320.field3930};
      class320[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class320 var4 = var2[var3];
         if(var0 == var4.field3929) {
            return var4;
         }
      }

      return null;
   }
}
