import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class160 implements class159 {
   @ObfuscatedName("mm")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   @Export("varcs")
   static Varcs varcs;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1783198553
   )
   static int field2146;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;Lhh;B)Lhh;",
      garbageValue = "-115"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = CacheFile.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lly;B)I",
      garbageValue = "60"
   )
   public static final int method3262(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field4075) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1519736212"
   )
   public static String method3263(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = OwnWorldComparator.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-2145205194"
   )
   static final void method3261(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2999(var0, var1, var2);
      int[] var8 = Region.method2999(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }
}
