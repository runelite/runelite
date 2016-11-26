import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("CombatInfo2")
public class class193 extends CacheableNode {
   @ObfuscatedName("h")
   static NodeCache field2831 = new NodeCache(64);
   @ObfuscatedName("d")
   static class182 field2832;
   @ObfuscatedName("m")
   public static NodeCache field2833 = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -829325963
   )
   int field2834 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -882865953
   )
   public int field2835;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1782388835
   )
   public int field2837 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1307009185
   )
   public int field2838 = 255;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1623523829
   )
   public int field2839 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1193590921
   )
   public int field2840 = 255;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1929330657
   )
   public int field2841 = 70;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1250006731
   )
   int field2842 = -1;
   @ObfuscatedName("n")
   public static class182 field2843;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -582884331
   )
   @Export("healthScale")
   public int field2844 = 30;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1425836279
   )
   public int field2845 = 0;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "-1226780588"
   )
   static class109 method3569() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-748852176"
   )
   void method3570(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2838 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2840 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2837 = 0;
      } else if(var2 == 5) {
         this.field2841 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2842 = var1.method3005();
      } else if(var2 == 8) {
         this.field2834 = var1.method3005();
      } else if(var2 == 11) {
         this.field2837 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field2844 = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2845 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-336360096"
   )
   public SpritePixels method3572() {
      if(this.field2842 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2831.get((long)this.field2842);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class207.method3894(field2832, this.field2842, 0);
            if(null != var1) {
               field2831.put(var1, (long)this.field2842);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1618545112"
   )
   public void method3579(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3570(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "16"
   )
   public static int method3586(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1533676647"
   )
   public SpritePixels method3587() {
      if(this.field2834 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2831.get((long)this.field2834);
         if(null != var1) {
            return var1;
         } else {
            var1 = class207.method3894(field2832, this.field2834, 0);
            if(var1 != null) {
               field2831.put(var1, (long)this.field2834);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "3"
   )
   static Class method3588(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
