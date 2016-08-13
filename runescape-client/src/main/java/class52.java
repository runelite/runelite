import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class52 extends CacheableNode {
   @ObfuscatedName("h")
   public String field1151 = "null";
   @ObfuscatedName("l")
   static class170 field1152;
   @ObfuscatedName("cy")
   static class146 field1153;
   @ObfuscatedName("e")
   public char field1154;
   @ObfuscatedName("r")
   public char field1155;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 716358757
   )
   public int field1156;
   @ObfuscatedName("g")
   static NodeCache field1157 = new NodeCache(64);
   @ObfuscatedName("u")
   public int[] field1158;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1153568599
   )
   public int field1159 = 0;
   @ObfuscatedName("n")
   public int[] field1160;
   @ObfuscatedName("b")
   public String[] field1163;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1968132103"
   )
   void method1119(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1155 = (char)var1.method2633();
      } else if(var2 == 2) {
         this.field1154 = (char)var1.method2633();
      } else if(var2 == 3) {
         this.field1151 = var1.method2663();
      } else if(var2 == 4) {
         this.field1156 = var1.method2620();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1159 = var1.method2635();
            this.field1158 = new int[this.field1159];
            this.field1163 = new String[this.field1159];

            for(var3 = 0; var3 < this.field1159; ++var3) {
               this.field1158[var3] = var1.method2620();
               this.field1163[var3] = var1.method2663();
            }
         } else if(var2 == 6) {
            this.field1159 = var1.method2635();
            this.field1158 = new int[this.field1159];
            this.field1160 = new int[this.field1159];

            for(var3 = 0; var3 < this.field1159; ++var3) {
               this.field1158[var3] = var1.method2620();
               this.field1160[var3] = var1.method2620();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2122920260"
   )
   void method1124(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1119(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1261213280"
   )
   public static Object method1131(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2090) {
            try {
               class121 var2 = new class121();
               var2.vmethod2940(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2090 = true;
            }
         }

         return var0;
      }
   }
}
