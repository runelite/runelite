import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("d")
   static IndexDataBase field2799;
   @ObfuscatedName("c")
   static IndexDataBase field2800;
   @ObfuscatedName("n")
   public static NodeCache field2801;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1087348251
   )
   int field2802;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -438447953
   )
   int field2804;
   @ObfuscatedName("v")
   short[] field2805;
   @ObfuscatedName("z")
   short[] field2806;
   @ObfuscatedName("l")
   short[] field2807;
   @ObfuscatedName("q")
   public static NodeCache field2808;
   @ObfuscatedName("g")
   short[] field2809;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -220036409
   )
   int field2810;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1000244325
   )
   public int field2811;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -723128553
   )
   int field2812;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1666787275
   )
   int field2813;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1518442913
   )
   int field2814;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 225598885
   )
   int field2816;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1175607437"
   )
   void method3475(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3477(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-365137369"
   )
   void method3477(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2804 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2811 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2810 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2802 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2812 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2813 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2814 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2806 = new short[var3];
            this.field2807 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2806[var4] = (short)var1.readUnsignedShort();
               this.field2807[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2805 = new short[var3];
            this.field2809 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2805[var4] = (short)var1.readUnsignedShort();
               this.field2809[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "858443194"
   )
   public final Model method3478(int var1) {
      Model var2 = (Model)field2808.get((long)this.field2816);
      if(var2 == null) {
         ModelData var3 = ModelData.method1479(field2800, this.field2804, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field2806 != null) {
            for(var4 = 0; var4 < this.field2806.length; ++var4) {
               var3.method1491(this.field2806[var4], this.field2807[var4]);
            }
         }

         if(this.field2805 != null) {
            for(var4 = 0; var4 < this.field2805.length; ++var4) {
               var3.method1492(this.field2805[var4], this.field2809[var4]);
            }
         }

         var2 = var3.method1502(this.field2813 + 64, this.field2814 + 850, -30, -50, -30);
         field2808.put(var2, (long)this.field2816);
      }

      Model var5;
      if(this.field2811 != -1 && var1 != -1) {
         var5 = NPCComposition.getAnimation(this.field2811).method3864(var2, var1);
      } else {
         var5 = var2.method1572(true);
      }

      if(this.field2810 != 128 || this.field2802 != 128) {
         var5.method1582(this.field2810, this.field2802, this.field2810);
      }

      if(this.field2812 != 0) {
         if(this.field2812 == 90) {
            var5.method1598();
         }

         if(this.field2812 == 180) {
            var5.method1598();
            var5.method1598();
         }

         if(this.field2812 == 270) {
            var5.method1598();
            var5.method1598();
            var5.method1598();
         }
      }

      return var5;
   }

   Spotanim() {
      this.field2811 = -1;
      this.field2810 = 128;
      this.field2802 = 128;
      this.field2812 = 0;
      this.field2813 = 0;
      this.field2814 = 0;
   }

   static {
      field2801 = new NodeCache(64);
      field2808 = new NodeCache(30);
   }
}
