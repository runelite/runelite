import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1153981271
   )
   public int field2993 = 32;
   @ObfuscatedName("g")
   static class182 field2994;
   @ObfuscatedName("x")
   public static NodeCache field2995 = new NodeCache(64);
   @ObfuscatedName("q")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("aw")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("k")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 992888969
   )
   public int field2999 = 1;
   @ObfuscatedName("s")
   @Export("models")
   int[] models;
   @ObfuscatedName("o")
   int[] field3001;
   @ObfuscatedName("z")
   short[] field3002;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 766594345
   )
   public int field3003 = -1;
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1213865623
   )
   public int field3005 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1476024551
   )
   public int field3006 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1917308221
   )
   public int field3007 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -708666965
   )
   public int field3008 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1877498083
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   short[] field3010;
   @ObfuscatedName("f")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1095835421
   )
   public int field3012 = -1;
   @ObfuscatedName("v")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 975118063
   )
   int field3014 = 128;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1495532249
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 549995735
   )
   int field3016 = 128;
   @ObfuscatedName("p")
   static class182 field3017;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -500414777
   )
   public int field3018 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1655686533
   )
   int field3019 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -128457819
   )
   int field3020 = 0;
   @ObfuscatedName("w")
   short[] field3021;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1620250677
   )
   public int field3022 = -1;
   @ObfuscatedName("aj")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2013261
   )
   int field3024 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1607208563
   )
   int field3025 = -1;
   @ObfuscatedName("ar")
   public boolean field3026 = true;
   @ObfuscatedName("y")
   short[] field3027;
   @ObfuscatedName("ay")
   public boolean field3028 = false;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-2118230442"
   )
   public final ModelData method3702() {
      if(this.configs != null) {
         NPCComposition var1 = this.method3708();
         return null == var1?null:var1.method3702();
      } else if(this.field3001 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var5 = 0; var5 < this.field3001.length; ++var5) {
            if(!field2994.method3326(this.field3001[var5], 0)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3001.length];

            for(int var3 = 0; var3 < this.field3001.length; ++var3) {
               var2[var3] = ModelData.method1459(field2994, this.field3001[var3], 0);
            }

            ModelData var7;
            if(var2.length == 1) {
               var7 = var2[0];
            } else {
               var7 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field3002 != null) {
               for(var4 = 0; var4 < this.field3002.length; ++var4) {
                  var7.method1471(this.field3002[var4], this.field3010[var4]);
               }
            }

            if(this.field3021 != null) {
               for(var4 = 0; var4 < this.field3021.length; ++var4) {
                  var7.method1472(this.field3021[var4], this.field3027[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1414049027"
   )
   void method3703() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-2"
   )
   void method3704(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3705(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "659090636"
   )
   void method3705(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2846();
      } else if(var2 == 12) {
         this.field2999 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3022 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3005 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3003 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3018 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3005 = var1.readUnsignedShort();
         this.field3006 = var1.readUnsignedShort();
         this.field3007 = var1.readUnsignedShort();
         this.field3008 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2846();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3002 = new short[var3];
         this.field3010 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3002[var4] = (short)var1.readUnsignedShort();
            this.field3010[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3021 = new short[var3];
         this.field3027 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3021[var4] = (short)var1.readUnsignedShort();
            this.field3027[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3001 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3001[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3014 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3019 = var1.readByte();
      } else if(var2 == 101) {
         this.field3020 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3012 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field2993 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3026 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3028 = true;
         }
      } else {
         this.field3024 = var1.readUnsignedShort();
         if(this.field3024 == '\uffff') {
            this.field3024 = -1;
         }

         this.field3025 = var1.readUnsignedShort();
         if(this.field3025 == '\uffff') {
            this.field3025 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "71"
   )
   public final Model method3707(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.configs) {
         NPCComposition var12 = this.method3708();
         return null == var12?null:var12.method3707(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field2994.method3326(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1459(field2994, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(null != this.field3002) {
               for(var9 = 0; var9 < this.field3002.length; ++var9) {
                  var11.method1471(this.field3002[var9], this.field3010[var9]);
               }
            }

            if(this.field3021 != null) {
               for(var9 = 0; var9 < this.field3021.length; ++var9) {
                  var11.method1472(this.field3021[var9], this.field3027[var9]);
               }
            }

            var5 = var11.method1479(this.field3019 + 64, 850 + this.field3020, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method3753(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method3775(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method3775(var5, var4);
         } else {
            var10 = var5.method1555(true);
         }

         if(this.field3016 != 128 || this.field3014 != 128) {
            var10.method1601(this.field3016, this.field3014, this.field3016);
         }

         return var10;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "-53"
   )
   public final NPCComposition method3708() {
      int var1 = -1;
      if(this.field3024 != -1) {
         var1 = class8.method114(this.field3024);
      } else if(this.field3025 != -1) {
         var1 = class165.widgetSettings[this.field3025];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Tile.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-89"
   )
   public boolean method3715() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3024 != -1) {
            var1 = class8.method114(this.field3024);
         } else if(this.field3025 != -1) {
            var1 = class165.widgetSettings[this.field3025];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILclass182;IIIZB)V",
      garbageValue = "-19"
   )
   public static void method3725(int var0, class182 var1, int var2, int var3, int var4, boolean var5) {
      class138.field1921 = 1;
      Item.field887 = var1;
      class181.field2695 = var2;
      Frames.field1569 = var3;
      class105.field1721 = var4;
      class138.field1922 = var5;
      class138.field1926 = var0;
   }
}
