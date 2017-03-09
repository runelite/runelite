import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class195 extends CacheableNode {
   @ObfuscatedName("j")
   public static NodeCache field2849 = new NodeCache(64);
   @ObfuscatedName("x")
   public static class182 field2850;
   @ObfuscatedName("c")
   public char field2851;
   @ObfuscatedName("d")
   public char field2852;
   @ObfuscatedName("w")
   public String field2853 = "null";
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1076357479
   )
   public int field2854;
   @ObfuscatedName("k")
   public int[] field2856;
   @ObfuscatedName("g")
   public int[] field2857;
   @ObfuscatedName("y")
   public String[] field2858;
   @ObfuscatedName("bl")
   static class184 field2859;
   @ObfuscatedName("e")
   static int[] field2860;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1527211225
   )
   public int field2861 = 0;
   @ObfuscatedName("ns")
   static class51 field2863;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "37"
   )
   void method3573(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2851 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2852 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2853 = var1.readString();
      } else if(var2 == 4) {
         this.field2854 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2861 = var1.readUnsignedShort();
            this.field2856 = new int[this.field2861];
            this.field2858 = new String[this.field2861];

            for(var3 = 0; var3 < this.field2861; ++var3) {
               this.field2856[var3] = var1.readInt();
               this.field2858[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2861 = var1.readUnsignedShort();
            this.field2856 = new int[this.field2861];
            this.field2857 = new int[this.field2861];

            for(var3 = 0; var3 < this.field2861; ++var3) {
               this.field2856[var3] = var1.readInt();
               this.field2857[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "4"
   )
   public static String method3574(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3099[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class206.field3099[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3099[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3099[var7 & 63]);
            } else {
               var3.append(class206.field3099[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3099[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "86"
   )
   static final void method3577(int var0) {
      if(class44.method892(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2308 = 0;
               var3.field2213 = 0;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "453675271"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2937.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2940.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2901 = var0;
         if(var2 != null) {
            var1.method3645(new Buffer(var2));
         }

         var1.method3613();
         if(var1.isSolid) {
            var1.field2911 = 0;
            var1.field2920 = false;
         }

         ObjectComposition.field2937.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1357744537"
   )
   public void method3580(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3573(var1, var2);
      }
   }
}
