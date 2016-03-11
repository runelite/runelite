import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class52 extends class203 {
   @ObfuscatedName("a")
   public static class192 field1165 = new class192(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1327305007
   )
   public static int field1166;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1947443531
   )
   public int field1168 = 0;
   @ObfuscatedName("ie")
   static class172 field1171;
   @ObfuscatedName("j")
   static class166 field1172;
   @ObfuscatedName("k")
   public static short[][] field1173;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "-1288966774"
   )
   void method1082(class118 var1, int var2) {
      if(var2 == 5) {
         this.field1168 = var1.method2455();
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "4"
   )
   static final void method1090(boolean var0) {
      for(int var1 = 0; var1 < client.field561; ++var1) {
         class34 var2 = client.field324[client.field326[var1]];
         int var3 = (client.field326[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod753() && var0 == var2.field779.field904 && var2.field779.method772()) {
            int var4 = var2.field839 >> 7;
            int var5 = var2.field848 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(1 == var2.field814 && 64 == (var2.field839 & 127) && 64 == (var2.field848 & 127)) {
                  if(client.field393[var4][var5] == client.field407) {
                     continue;
                  }

                  client.field393[var4][var5] = client.field407;
               }

               if(!var2.field779.field883) {
                  var3 -= Integer.MIN_VALUE;
               }

               class107.field1906.method1886(class75.field1386, var2.field839, var2.field848, class105.method2335(var2.field839 + (var2.field814 * 64 - 64), var2.field814 * 64 - 64 + var2.field848, class75.field1386), 60 + (var2.field814 * 64 - 64), var2, var2.field852, var3, var2.field813);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass118;I)V",
      garbageValue = "1466304381"
   )
   void method1093(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(var2 == 0) {
            return;
         }

         this.method1082(var1, var2);
      }
   }
}
