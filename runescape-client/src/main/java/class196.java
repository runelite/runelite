import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class196 extends CacheableNode {
   @ObfuscatedName("f")
   static class182 field2872;
   @ObfuscatedName("c")
   static class182 field2873;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -914107295
   )
   int field2874 = -1;
   @ObfuscatedName("h")
   public static NodeCache field2875 = new NodeCache(64);
   @ObfuscatedName("a")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("g")
   public static NodeCache field2877 = new NodeCache(20);
   @ObfuscatedName("s")
   static class182 field2880;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2101011797
   )
   public int field2881 = 16777215;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2010809773
   )
   public int field2882 = 70;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -955307629
   )
   int field2883 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1134759059
   )
   int field2884 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -628240443
   )
   int field2885 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -873263201
   )
   int field2886 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -855734919
   )
   public int field2887 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -554119387
   )
   public int field2888 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2065105815
   )
   public int field2889 = -1;
   @ObfuscatedName("t")
   String field2890 = "";
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1618697651
   )
   public int field2891 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 289831743
   )
   int field2892 = -1;
   @ObfuscatedName("l")
   public int[] field2893;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -184548353
   )
   int field2894 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -115000487
   )
   public int field2895 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "485932933"
   )
   void method3453(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3454(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "507383682"
   )
   void method3454(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2892 = var1.method2737();
      } else if(var2 == 2) {
         this.field2881 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2883 = var1.method2737();
      } else if(var2 == 4) {
         this.field2885 = var1.method2737();
      } else if(var2 == 5) {
         this.field2884 = var1.method2737();
      } else if(var2 == 6) {
         this.field2886 = var1.method2737();
      } else if(var2 == 7) {
         this.field2895 = var1.readShort();
      } else if(var2 == 8) {
         this.field2890 = var1.method2852();
      } else if(var2 == 9) {
         this.field2882 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2888 = var1.readShort();
      } else if(var2 == 11) {
         this.field2889 = 0;
      } else if(var2 == 12) {
         this.field2891 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2887 = var1.readShort();
      } else if(var2 == 14) {
         this.field2889 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2894 = var1.readUnsignedShort();
         if(this.field2894 == '\uffff') {
            this.field2894 = -1;
         }

         this.field2874 = var1.readUnsignedShort();
         if(this.field2874 == '\uffff') {
            this.field2874 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2893 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2893[var5] = var1.readUnsignedShort();
            if(this.field2893[var5] == '\uffff') {
               this.field2893[var5] = -1;
            }
         }

         this.field2893[1 + var4] = var3;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lclass196;",
      garbageValue = "-13"
   )
   public final class196 method3455() {
      int var1 = -1;
      if(this.field2894 != -1) {
         var1 = class20.method174(this.field2894);
      } else if(this.field2874 != -1) {
         var1 = class165.widgetSettings[this.field2874];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2893.length - 1) {
         var2 = this.field2893[var1];
      } else {
         var2 = this.field2893[this.field2893.length - 1];
      }

      return var2 != -1?class97.method1871(var2):null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-682020120"
   )
   public SpritePixels method3456() {
      if(this.field2883 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2883);
         if(null != var1) {
            return var1;
         } else {
            var1 = class37.method717(field2873, this.field2883, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2883);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "24778"
   )
   public SpritePixels method3457() {
      if(this.field2884 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2884);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class37.method717(field2873, this.field2884, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2884);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-39"
   )
   public SpritePixels method3458() {
      if(this.field2885 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2885);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class37.method717(field2873, this.field2885, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2885);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1552140122"
   )
   public SpritePixels method3459() {
      if(this.field2886 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2886);
         if(null != var1) {
            return var1;
         } else {
            var1 = class37.method717(field2873, this.field2886, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2886);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "-17060"
   )
   public String method3461(int var1) {
      String var2 = this.field2890;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-1336657411"
   )
   public Font method3473() {
      if(this.field2892 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2877.get((long)this.field2892);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class180.method3174(field2873, field2872, this.field2892, 0);
            if(var1 != null) {
               field2877.put(var1, (long)this.field2892);
            }

            return var1;
         }
      }
   }
}
