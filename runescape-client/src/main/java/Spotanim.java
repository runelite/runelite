import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("e")
   short[] field2785;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1157015341
   )
   int field2786 = 128;
   @ObfuscatedName("d")
   public static NodeCache field2787 = new NodeCache(30);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -263620601
   )
   int field2788;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2072126657
   )
   int field2789;
   @ObfuscatedName("j")
   static class182 field2790;
   @ObfuscatedName("k")
   short[] field2791;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 351694877
   )
   public int field2792 = -1;
   @ObfuscatedName("y")
   short[] field2793;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -432153817
   )
   int field2794 = 0;
   @ObfuscatedName("g")
   short[] field2795;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1279740823
   )
   int field2796 = 128;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1857426939
   )
   int field2797 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -619525445
   )
   int field2798 = 0;
   @ObfuscatedName("c")
   public static NodeCache field2799 = new NodeCache(64);
   @ObfuscatedName("ev")
   static ModIcon[] field2800;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1874597046"
   )
   void method3472(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3477(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "118"
   )
   public final Model method3474(int var1) {
      Model var2 = (Model)field2787.get((long)this.field2788);
      if(var2 == null) {
         ModelData var3 = ModelData.method1522(field2790, this.field2789, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field2791 != null) {
            for(var4 = 0; var4 < this.field2791.length; ++var4) {
               var3.method1555(this.field2791[var4], this.field2795[var4]);
            }
         }

         if(null != this.field2793) {
            for(var4 = 0; var4 < this.field2793.length; ++var4) {
               var3.method1536(this.field2793[var4], this.field2785[var4]);
            }
         }

         var2 = var3.method1543(this.field2798 + 64, this.field2794 + 850, -30, -50, -30);
         field2787.put(var2, (long)this.field2788);
      }

      Model var5;
      if(this.field2792 != -1 && var1 != -1) {
         var5 = class168.getAnimation(this.field2792).method3765(var2, var1);
      } else {
         var5 = var2.method1615(true);
      }

      if(this.field2786 != 128 || this.field2796 != 128) {
         var5.method1627(this.field2786, this.field2796, this.field2786);
      }

      if(this.field2797 != 0) {
         if(this.field2797 == 90) {
            var5.method1647();
         }

         if(this.field2797 == 180) {
            var5.method1647();
            var5.method1647();
         }

         if(this.field2797 == 270) {
            var5.method1647();
            var5.method1647();
            var5.method1647();
         }
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "319216995"
   )
   void method3477(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2789 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2792 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2786 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2796 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2797 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2798 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2794 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2791 = new short[var3];
            this.field2795 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2791[var4] = (short)var1.readUnsignedShort();
               this.field2795[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2793 = new short[var3];
            this.field2785 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2793[var4] = (short)var1.readUnsignedShort();
               this.field2785[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static void method3484() {
      class45.field934 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field923[var0] = null;
         class45.field935[var0] = 1;
      }

   }
}
