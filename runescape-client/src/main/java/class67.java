import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class67 extends class196 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2076352289
   )
   int field836;
   @ObfuscatedName("a")
   short field837;
   @ObfuscatedName("v")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("w")
   String field841;

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lclass89;III)V",
      garbageValue = "2059490363"
   )
   static final void method1122(class89 var0, int var1, int var2) {
      Item.menuAction(var0.field1433, var0.field1429, var0.field1427, var0.field1428, var0.field1425, var0.field1425, var1, var2);
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "1031531963"
   )
   static void method1123(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1181 < 50 && Client.field1098 != 0) {
         if(var0.field3613 != null && var1 < var0.field3613.length) {
            int var4 = var0.field3613[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1168[Client.field1181] = var5;
               Client.field1169[Client.field1181] = var6;
               Client.field1170[Client.field1181] = 0;
               Client.audioEffects[Client.field1181] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1171[Client.field1181] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field1181;
            }
         }
      }
   }

   class67(String var1, int var2) {
      this.field836 = (int)(class172.method3128() / 1000L);
      this.field841 = var1;
      this.field837 = (short)var2;
   }
}
