import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("i")
   short[] field2797;
   @ObfuscatedName("p")
   static NodeCache field2798 = new NodeCache(30);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2037644851
   )
   int field2799;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1838347175
   )
   int field2800;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 471475971
   )
   int field2801 = 0;
   @ObfuscatedName("c")
   short[] field2802;
   @ObfuscatedName("h")
   static NodeCache field2803 = new NodeCache(64);
   @ObfuscatedName("o")
   short[] field2804;
   @ObfuscatedName("m")
   short[] field2805;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 519634973
   )
   int field2806 = 128;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1953327987
   )
   public int field2807 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1995539373
   )
   int field2808 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -374763971
   )
   int field2809 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -763638909
   )
   int field2810 = 128;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1947520523"
   )
   void method3471(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2800 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2807 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2806 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2810 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2801 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2808 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2809 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2802 = new short[var3];
            this.field2797 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2802[var4] = (short)var1.readUnsignedShort();
               this.field2797[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2804 = new short[var3];
            this.field2805 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2804[var4] = (short)var1.readUnsignedShort();
               this.field2805[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-23"
   )
   public final Model method3472(int var1) {
      Model var2 = (Model)field2798.get((long)this.field2799);
      if(var2 == null) {
         ModelData var3 = ModelData.method1559(class0.field6, this.field2800, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field2802) {
            for(var4 = 0; var4 < this.field2802.length; ++var4) {
               var3.method1526(this.field2802[var4], this.field2797[var4]);
            }
         }

         if(this.field2804 != null) {
            for(var4 = 0; var4 < this.field2804.length; ++var4) {
               var3.method1564(this.field2804[var4], this.field2805[var4]);
            }
         }

         var2 = var3.method1534(this.field2808 + 64, 850 + this.field2809, -30, -50, -30);
         field2798.put(var2, (long)this.field2799);
      }

      Model var5;
      if(this.field2807 != -1 && var1 != -1) {
         var5 = class195.getAnimation(this.field2807).method3811(var2, var1);
      } else {
         var5 = var2.method1615(true);
      }

      if(this.field2806 != 128 || this.field2810 != 128) {
         var5.method1628(this.field2806, this.field2810, this.field2806);
      }

      if(this.field2801 != 0) {
         if(this.field2801 == 90) {
            var5.method1623();
         }

         if(this.field2801 == 180) {
            var5.method1623();
            var5.method1623();
         }

         if(this.field2801 == 270) {
            var5.method1623();
            var5.method1623();
            var5.method1623();
         }
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1006308645"
   )
   void method3477(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3471(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "-18"
   )
   static void method3482(World var0) {
      if(var0.method668() != Client.isMembers) {
         Client.isMembers = var0.method668();
         class33.method787(var0.method668());
      }

      class101.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class16.field187 = Client.field305 == 0?'ꩊ':'鱀' + var0.id;
      class164.field2158 = Client.field305 == 0?443:'썐' + var0.id;
      class142.field1999 = class16.field187;
   }
}
