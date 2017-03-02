import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("t")
   public static NodeCache field2791 = new NodeCache(30);
   @ObfuscatedName("l")
   public static class182 field2792;
   @ObfuscatedName("a")
   short[] field2793;
   @ObfuscatedName("b")
   public static class182 field2794;
   @ObfuscatedName("x")
   short[] field2795;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -355995705
   )
   int field2796;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1421809571
   )
   public int field2797 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1776834025
   )
   int field2798;
   @ObfuscatedName("r")
   short[] field2800;
   @ObfuscatedName("f")
   short[] field2801;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -113729821
   )
   int field2802 = 128;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1759962067
   )
   int field2803 = 128;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 652158897
   )
   int field2804 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 157455145
   )
   int field2805 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2063629063
   )
   int field2806 = 0;
   @ObfuscatedName("i")
   public static NodeCache field2809 = new NodeCache(64);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1059615414"
   )
   void method3537(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3538(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "9"
   )
   void method3538(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2796 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2797 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2802 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2803 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2805 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2806 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2801 = new short[var3];
            this.field2793 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2801[var4] = (short)var1.readUnsignedShort();
               this.field2793[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2800 = new short[var3];
            this.field2795 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2800[var4] = (short)var1.readUnsignedShort();
               this.field2795[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-19"
   )
   public final Model method3539(int var1) {
      Model var2 = (Model)field2791.get((long)this.field2798);
      if(var2 == null) {
         ModelData var3 = ModelData.method1563(field2792, this.field2796, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field2801 != null) {
            for(var4 = 0; var4 < this.field2801.length; ++var4) {
               var3.method1579(this.field2801[var4], this.field2793[var4]);
            }
         }

         if(null != this.field2800) {
            for(var4 = 0; var4 < this.field2800.length; ++var4) {
               var3.method1541(this.field2800[var4], this.field2795[var4]);
            }
         }

         var2 = var3.method1544(this.field2805 + 64, 850 + this.field2806, -30, -50, -30);
         field2791.put(var2, (long)this.field2798);
      }

      Model var5;
      if(this.field2797 != -1 && var1 != -1) {
         var5 = XClanMember.getAnimation(this.field2797).method3861(var2, var1);
      } else {
         var5 = var2.method1672(true);
      }

      if(this.field2802 != 128 || this.field2803 != 128) {
         var5.method1648(this.field2802, this.field2803, this.field2802);
      }

      if(this.field2804 != 0) {
         if(this.field2804 == 90) {
            var5.method1655();
         }

         if(this.field2804 == 180) {
            var5.method1655();
            var5.method1655();
         }

         if(this.field2804 == 270) {
            var5.method1655();
            var5.method1655();
            var5.method1655();
         }
      }

      return var5;
   }
}
