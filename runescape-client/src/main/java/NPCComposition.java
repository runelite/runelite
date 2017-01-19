import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("ao")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("c")
   static class182 field3005;
   @ObfuscatedName("f")
   public static NodeCache field3006 = new NodeCache(64);
   @ObfuscatedName("h")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1365269245
   )
   @Export("id")
   public int id;
   @ObfuscatedName("g")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -340147529
   )
   public int field3010 = 1;
   @ObfuscatedName("s")
   static class182 field3012;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1258481425
   )
   public int field3013 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 947185939
   )
   public int field3014 = 32;
   @ObfuscatedName("b")
   int[] field3015;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -308830291
   )
   public int field3016 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1176989577
   )
   public int field3017 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1621181561
   )
   public int field3018 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1410074757
   )
   public int field3019 = -1;
   @ObfuscatedName("o")
   short[] field3020;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 550289921
   )
   public int field3021 = -1;
   @ObfuscatedName("z")
   short[] field3022;
   @ObfuscatedName("e")
   short[] field3023;
   @ObfuscatedName("d")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -528634913
   )
   int field3025 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 924885369
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1311367545
   )
   int field3027 = 128;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -634517981
   )
   int field3028 = 128;
   @ObfuscatedName("v")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1397754009
   )
   int field3030 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1117920155
   )
   int field3031 = 0;
   @ObfuscatedName("u")
   @Export("models")
   int[] models;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -530985565
   )
   public int field3033 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1521251579
   )
   int field3034 = -1;
   @ObfuscatedName("t")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 332723359
   )
   public int field3036 = -1;
   @ObfuscatedName("al")
   public boolean field3037 = true;
   @ObfuscatedName("an")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("aw")
   public boolean field3039 = false;
   @ObfuscatedName("i")
   short[] field3040;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "883345780"
   )
   void method3570() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "15"
   )
   void method3572(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.method2911();
      } else if(var2 == 12) {
         this.field3010 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3013 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3036 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3033 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3016 = var1.readUnsignedShort();
         this.field3017 = var1.readUnsignedShort();
         this.field3018 = var1.readUnsignedShort();
         this.field3019 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2911();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3020 = new short[var3];
         this.field3040 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3020[var4] = (short)var1.readUnsignedShort();
            this.field3040[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3022 = new short[var3];
         this.field3023 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3022[var4] = (short)var1.readUnsignedShort();
            this.field3023[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3015 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3015[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3027 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3028 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3030 = var1.readByte();
      } else if(var2 == 101) {
         this.field3031 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3021 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3014 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3037 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3039 = true;
         }
      } else {
         this.field3034 = var1.readUnsignedShort();
         if(this.field3034 == '\uffff') {
            this.field3034 = -1;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "296550661"
   )
   public boolean method3573() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3034 != -1) {
            var1 = class20.method174(this.field3034);
         } else if(this.field3025 != -1) {
            var1 = class165.widgetSettings[this.field3025];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-85974512"
   )
   public final ModelData method3574() {
      if(this.configs != null) {
         NPCComposition var5 = this.method3576();
         return var5 == null?null:var5.method3574();
      } else if(this.field3015 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field3015.length; ++var2) {
            if(!field3005.method3184(this.field3015[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3015.length];

            for(int var3 = 0; var3 < this.field3015.length; ++var3) {
               var6[var3] = ModelData.method1426(field3005, this.field3015[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3020 != null) {
               for(var4 = 0; var4 < this.field3020.length; ++var4) {
                  var7.method1439(this.field3020[var4], this.field3040[var4]);
               }
            }

            if(null != this.field3022) {
               for(var4 = 0; var4 < this.field3022.length; ++var4) {
                  var7.method1440(this.field3022[var4], this.field3023[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)LNPCComposition;",
      garbageValue = "11"
   )
   public final NPCComposition method3576() {
      int var1 = -1;
      if(this.field3034 != -1) {
         var1 = class20.method174(this.field3034);
      } else if(this.field3025 != -1) {
         var1 = class165.widgetSettings[this.field3025];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Buffer.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-675541239"
   )
   static void method3583() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2283(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2277()) {
         int var1 = var0.id;
         if(class109.method1999(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class108.method1988(var4);
               if(null != var5) {
                  class204.method3671(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "627901972"
   )
   void method3588(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3572(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-376186831"
   )
   public final Model method3591(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.configs) {
         NPCComposition var12 = this.method3576();
         return null == var12?null:var12.method3591(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var11 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field3005.method3184(this.models[var10], 0)) {
                  var11 = true;
               }
            }

            if(var11) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1426(field3005, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(this.field3020 != null) {
               for(var9 = 0; var9 < this.field3020.length; ++var9) {
                  var7.method1439(this.field3020[var9], this.field3040[var9]);
               }
            }

            if(null != this.field3022) {
               for(var9 = 0; var9 < this.field3022.length; ++var9) {
                  var7.method1440(this.field3022[var9], this.field3023[var9]);
               }
            }

            var5 = var7.method1446(this.field3030 + 64, 850 + this.field3031, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(null != var1 && null != var3) {
            var6 = var1.method3638(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method3611(var5, var2);
         } else if(null != var3) {
            var6 = var3.method3611(var5, var4);
         } else {
            var6 = var5.method1519(true);
         }

         if(this.field3027 != 128 || this.field3028 != 128) {
            var6.method1546(this.field3027, this.field3028, this.field3027);
         }

         return var6;
      }
   }
}
