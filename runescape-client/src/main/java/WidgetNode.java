import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1657962965
   )
   @Export("id")
   int id;
   @ObfuscatedName("ee")
   static SpritePixels[] field64;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -468506333
   )
   static int field65;
   @ObfuscatedName("eb")
   static SpritePixels[] field66;
   @ObfuscatedName("e")
   boolean field67 = false;
   @ObfuscatedName("gj")
   static Widget field69;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -729391483
   )
   int field70;
   @ObfuscatedName("v")
   static String field72;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "793456850"
   )
   public static void method50() {
      NPCComposition.field906.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-24"
   )
   public static byte[] method51(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class35.method739(var3):var3;
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2822();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
