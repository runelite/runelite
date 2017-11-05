import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class40 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   public static final class40 field567;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   public static final class40 field564;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   public static final class40 field565;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   public static final class40 field566;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   public static final class40 field568;
   @ObfuscatedName("l")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("v")
   public final String field563;

   static {
      field567 = new class40("details");
      field564 = new class40("compositemap");
      field565 = new class40("compositetexture");
      field566 = new class40("area");
      field568 = new class40("labels");
   }

   class40(String var1) {
      this.field563 = var1;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(Ljt;IIII)V",
      garbageValue = "1956452072"
   )
   static void method539(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1154 < 50 && Client.field922 != 0) {
         if(var0.field3609 != null && var1 < var0.field3609.length) {
            int var4 = var0.field3609[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1098[Client.field1154] = var5;
               Client.field1156[Client.field1154] = var6;
               Client.field1136[Client.field1154] = 0;
               Client.audioEffects[Client.field1154] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1040[Client.field1154] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1154;
            }
         }
      }
   }
}
