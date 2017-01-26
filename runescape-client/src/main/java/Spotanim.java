import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("o")
   short[] field2788;
   @ObfuscatedName("q")
   public static NodeCache field2789 = new NodeCache(30);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 689116961
   )
   int field2790;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2042948035
   )
   int field2791;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1479602771
   )
   public int field2792 = -1;
   @ObfuscatedName("s")
   short[] field2793;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 231106345
   )
   int field2794 = 0;
   @ObfuscatedName("a")
   short[] field2795;
   @ObfuscatedName("c")
   short[] field2796;
   @ObfuscatedName("x")
   public static NodeCache field2797 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 682348017
   )
   int field2798 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2098399517
   )
   int field2799 = 0;
   @ObfuscatedName("g")
   public static class182 field2800;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1242424719
   )
   int field2801 = 0;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 474852017
   )
   static int field2802;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1905700059
   )
   int field2804 = 128;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "18"
   )
   void method3454(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3457(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-452721905"
   )
   public final Model method3456(int var1) {
      Model var2 = (Model)field2789.get((long)this.field2790);
      if(var2 == null) {
         ModelData var3 = ModelData.method1459(field2800, this.field2791, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field2793) {
            for(var4 = 0; var4 < this.field2793.length; ++var4) {
               var3.method1471(this.field2793[var4], this.field2788[var4]);
            }
         }

         if(this.field2795 != null) {
            for(var4 = 0; var4 < this.field2795.length; ++var4) {
               var3.method1472(this.field2795[var4], this.field2796[var4]);
            }
         }

         var2 = var3.method1479(this.field2799 + 64, this.field2801 + 850, -30, -50, -30);
         field2789.put(var2, (long)this.field2790);
      }

      Model var5;
      if(this.field2792 != -1 && var1 != -1) {
         var5 = class146.getAnimation(this.field2792).method3752(var2, var1);
      } else {
         var5 = var2.method1556(true);
      }

      if(this.field2804 != 128 || this.field2798 != 128) {
         var5.method1601(this.field2804, this.field2798, this.field2804);
      }

      if(this.field2794 != 0) {
         if(this.field2794 == 90) {
            var5.method1568();
         }

         if(this.field2794 == 180) {
            var5.method1568();
            var5.method1568();
         }

         if(this.field2794 == 270) {
            var5.method1568();
            var5.method1568();
            var5.method1568();
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "16"
   )
   void method3457(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2791 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2792 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2798 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2794 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2799 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2801 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2793 = new short[var3];
            this.field2788 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2793[var4] = (short)var1.readUnsignedShort();
               this.field2788[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2795 = new short[var3];
            this.field2796 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2795[var4] = (short)var1.readUnsignedShort();
               this.field2796[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1730764700"
   )
   static final void method3463(int var0, int var1) {
      int var2 = Tile.field1346.method3870("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         Font var4 = Tile.field1346;
         String var5;
         if(Client.menuTargets[var3].length() > 0) {
            var5 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var5 = Client.menuOptions[var3];
         }

         int var6 = var4.method3870(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class26.field577) {
         var7 = class26.field577 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var1 + var3 > class187.field2776) {
         var8 = class187.field2776 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      Renderable.region.method1736(WallObject.plane, var0, var1, false);
      Client.isMenuOpen = true;
      class185.menuX = var7;
      class103.menuY = var8;
      XClanMember.menuWidth = var2;
      class175.menuHeight = Client.menuOptionCount * 15 + 22;
   }
}
