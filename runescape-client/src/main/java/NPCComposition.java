import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("i")
   public static NodeCache field3006 = new NodeCache(64);
   @ObfuscatedName("l")
   static class182 field3007;
   @ObfuscatedName("c")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("t")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 74927167
   )
   int field3010 = 0;
   @ObfuscatedName("h")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -980169633
   )
   public int field3012 = 1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 810976179
   )
   int field3013 = 128;
   @ObfuscatedName("a")
   int[] field3014;
   @ObfuscatedName("g")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 616277989
   )
   public int field3016 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1991914197
   )
   public int field3017 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1254795869
   )
   public int field3018 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 571960979
   )
   public int field3019 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 887083573
   )
   public int field3020 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -189303467
   )
   public int field3021 = -1;
   @ObfuscatedName("w")
   short[] field3022;
   @ObfuscatedName("f")
   @Export("models")
   int[] models;
   @ObfuscatedName("u")
   short[] field3024;
   @ObfuscatedName("q")
   short[] field3025;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -272306699
   )
   @Export("id")
   public int id;
   @ObfuscatedName("v")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1602072003
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("au")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1902942373
   )
   int field3030 = 128;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1076502437
   )
   int field3031 = -1;
   @ObfuscatedName("m")
   short[] field3032;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -95000767
   )
   int field3033 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1008763119
   )
   public int field3034 = -1;
   @ObfuscatedName("aw")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 764696653
   )
   public int field3036 = -1;
   @ObfuscatedName("b")
   static class182 field3037;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -978796101
   )
   public int field3038 = 32;
   @ObfuscatedName("ae")
   public boolean field3039 = true;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -614056847
   )
   int field3040 = -1;
   @ObfuscatedName("am")
   public boolean field3041 = false;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   void method3803() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1982463113"
   )
   void method3804(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3818(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "0"
   )
   public final Model method3805(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3807();
         return null == var12?null:var12.method3805(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field3007.method3413(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1563(field3007, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(this.field3022 != null) {
               for(var9 = 0; var9 < this.field3022.length; ++var9) {
                  var7.method1579(this.field3022[var9], this.field3032[var9]);
               }
            }

            if(this.field3024 != null) {
               for(var9 = 0; var9 < this.field3024.length; ++var9) {
                  var7.method1541(this.field3024[var9], this.field3025[var9]);
               }
            }

            var5 = var7.method1544(this.field3010 + 64, 850 + this.field3033, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(null != var1 && var3 != null) {
            var11 = var1.method3881(var5, var2, var3, var4);
         } else if(null != var1) {
            var11 = var1.method3858(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method3858(var5, var4);
         } else {
            var11 = var5.method1610(true);
         }

         if(this.field3030 != 128 || this.field3013 != 128) {
            var11.method1648(this.field3030, this.field3013, this.field3030);
         }

         return var11;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1632328821"
   )
   public boolean method3806() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3031 != -1) {
            var1 = class156.method3084(this.field3031);
         } else if(this.field3040 != -1) {
            var1 = class165.widgetSettings[this.field3040];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "2134081417"
   )
   public final NPCComposition method3807() {
      int var1 = -1;
      if(this.field3031 != -1) {
         var1 = class156.method3084(this.field3031);
      } else if(this.field3040 != -1) {
         var1 = class165.widgetSettings[this.field3040];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?ChatLineBuffer.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "1816739088"
   )
   public static SpritePixels method3812(class182 var0, int var1, int var2) {
      return !class185.method3467(var0, var1, var2)?null:Player.method254();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-49798691"
   )
   public final ModelData method3813() {
      if(this.configs != null) {
         NPCComposition var1 = this.method3807();
         return var1 == null?null:var1.method3813();
      } else if(this.field3014 == null) {
         return null;
      } else {
         boolean var7 = false;

         for(int var6 = 0; var6 < this.field3014.length; ++var6) {
            if(!field3007.method3413(this.field3014[var6], 0)) {
               var7 = true;
            }
         }

         if(var7) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3014.length];

            for(int var5 = 0; var5 < this.field3014.length; ++var5) {
               var2[var5] = ModelData.method1563(field3007, this.field3014[var5], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(null != this.field3022) {
               for(var4 = 0; var4 < this.field3022.length; ++var4) {
                  var3.method1579(this.field3022[var4], this.field3032[var4]);
               }
            }

            if(this.field3024 != null) {
               for(var4 = 0; var4 < this.field3024.length; ++var4) {
                  var3.method1541(this.field3024[var4], this.field3025[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "583915808"
   )
   void method3818(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3012 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3018 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3036 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3017 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3036 = var1.readUnsignedShort();
         this.field3019 = var1.readUnsignedShort();
         this.field3020 = var1.readUnsignedShort();
         this.field3021 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3022 = new short[var3];
         this.field3032 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3022[var4] = (short)var1.readUnsignedShort();
            this.field3032[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3024 = new short[var3];
         this.field3025 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3024[var4] = (short)var1.readUnsignedShort();
            this.field3025[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3014 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3014[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3030 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3013 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3010 = var1.readByte();
      } else if(var2 == 101) {
         this.field3033 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3034 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3038 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3039 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3041 = true;
         }
      } else {
         this.field3031 = var1.readUnsignedShort();
         if(this.field3031 == '\uffff') {
            this.field3031 = -1;
         }

         this.field3040 = var1.readUnsignedShort();
         if(this.field3040 == '\uffff') {
            this.field3040 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[1 + var4] = var3;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-9486"
   )
   static final void method3831(int var0) {
      short var1 = 256;
      class41.field821 += var0 * 128;
      int var2;
      if(class41.field821 > Buffer.field2088.length) {
         class41.field821 -= Buffer.field2088.length;
         var2 = (int)(Math.random() * 12.0D);
         Tile.method1607(class6.field53[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class41.field828[var2 + var3] - Buffer.field2088[class41.field821 + var2 & Buffer.field2088.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class41.field828[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class41.field828[var7 + var6] = 255;
            } else {
               class41.field828[var7 + var6] = 0;
            }
         }
      }

      if(class41.field826 > 0) {
         class41.field826 -= var0 * 4;
      }

      if(class41.field827 > 0) {
         class41.field827 -= 4 * var0;
      }

      if(class41.field826 == 0 && class41.field827 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class41.field826 = 1024;
         }

         if(var5 == 1) {
            class41.field827 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class41.field825[var5] = class41.field825[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class41.field825[var5] = (int)(Math.sin((double)class41.field824 / 14.0D) * 16.0D + Math.sin((double)class41.field824 / 15.0D) * 14.0D + Math.sin((double)class41.field824 / 16.0D) * 12.0D);
         ++class41.field824;
      }

      class41.field847 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class41.field847 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class41.field828[var7 + (var8 << 7)] = 192;
         }

         class41.field847 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class41.field828[var8 + var9 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class41.field828[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class5.field51[var9 + var8] = var7 / (1 + var5 * 2);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class5.field51[var9 + var6 + 128 * var5];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= class5.field51[var9 + var6 - 128 * (1 + var5)];
               }

               if(var8 >= 0) {
                  class41.field828[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "1100307657"
   )
   public static class196 method3832(int var0) {
      class196 var1 = (class196)class196.field2873.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2880.getConfigData(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3666(new Buffer(var2));
         }

         class196.field2873.put(var1, (long)var0);
         return var1;
      }
   }
}
