import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("as")
   public boolean field3002 = false;
   @ObfuscatedName("d")
   public static class182 field3003;
   @ObfuscatedName("h")
   static NodeCache field3004 = new NodeCache(64);
   @ObfuscatedName("q")
   public static class182 field3005;
   @ObfuscatedName("e")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1629679567
   )
   public int field3007 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 66278181
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2077525655
   )
   public int field3010 = 1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1243812845
   )
   public int field3011 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 824910219
   )
   public int field3012 = -1;
   @ObfuscatedName("c")
   @Export("models")
   int[] models;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1449896561
   )
   public int field3014 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1524972671
   )
   public int field3015 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 244183923
   )
   public int field3016 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1544635171
   )
   public int field3017 = -1;
   @ObfuscatedName("z")
   short[] field3018;
   @ObfuscatedName("t")
   short[] field3019;
   @ObfuscatedName("i")
   int[] field3020;
   @ObfuscatedName("w")
   short[] field3021;
   @ObfuscatedName("a")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("k")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 150859995
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -908758847
   )
   int field3025 = 128;
   @ObfuscatedName("p")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -806664207
   )
   int field3027 = 128;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -700574699
   )
   int field3028 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1571449625
   )
   int field3029 = 0;
   @ObfuscatedName("y")
   short[] field3030;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1605660793
   )
   public int field3031 = 32;
   @ObfuscatedName("am")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1868043443
   )
   int field3033 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 200878331
   )
   int field3034 = -1;
   @ObfuscatedName("ac")
   public boolean field3035 = true;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1482705749
   )
   public int field3037 = -1;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2120753124"
   )
   void method3730() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "324325840"
   )
   void method3732(Buffer var1, int var2) {
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
         this.field3010 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3011 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3037 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3012 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3014 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3037 = var1.readUnsignedShort();
         this.field3015 = var1.readUnsignedShort();
         this.field3016 = var1.readUnsignedShort();
         this.field3017 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3018 = new short[var3];
         this.field3019 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3018[var4] = (short)var1.readUnsignedShort();
            this.field3019[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3030 = new short[var3];
         this.field3021 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3030[var4] = (short)var1.readUnsignedShort();
            this.field3021[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3020 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3020[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3025 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3027 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3028 = var1.readByte();
      } else if(var2 == 101) {
         this.field3029 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3007 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3031 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3035 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3002 = true;
         }
      } else {
         this.field3033 = var1.readUnsignedShort();
         if(this.field3033 == '\uffff') {
            this.field3033 = -1;
         }

         this.field3034 = var1.readUnsignedShort();
         if(this.field3034 == '\uffff') {
            this.field3034 = -1;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-789340569"
   )
   public static Overlay method3733(int var0) {
      Overlay var1 = (Overlay)Overlay.field3041.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3038.getConfigData(4, var0);
         var1 = new Overlay();
         if(null != var2) {
            var1.method3754(new Buffer(var2), var0);
         }

         var1.method3753();
         Overlay.field3041.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-738159211"
   )
   public final NPCComposition method3735() {
      int var1 = -1;
      if(this.field3033 != -1) {
         var1 = class109.method2109(this.field3033);
      } else if(this.field3034 != -1) {
         var1 = class165.widgetSettings[this.field3034];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class13.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "972912289"
   )
   public boolean method3736() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3033 != -1) {
            var1 = class109.method2109(this.field3033);
         } else if(this.field3034 != -1) {
            var1 = class165.widgetSettings[this.field3034];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1288166903"
   )
   void method3737(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3732(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-269678306"
   )
   public final ModelData method3740() {
      if(this.configs != null) {
         NPCComposition var7 = this.method3735();
         return null == var7?null:var7.method3740();
      } else if(null == this.field3020) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field3020.length; ++var2) {
            if(!field3003.method3376(this.field3020[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var5 = new ModelData[this.field3020.length];

            for(int var6 = 0; var6 < this.field3020.length; ++var6) {
               var5[var6] = ModelData.method1559(field3003, this.field3020[var6], 0);
            }

            ModelData var3;
            if(var5.length == 1) {
               var3 = var5[0];
            } else {
               var3 = new ModelData(var5, var5.length);
            }

            int var4;
            if(this.field3018 != null) {
               for(var4 = 0; var4 < this.field3018.length; ++var4) {
                  var3.method1526(this.field3018[var4], this.field3019[var4]);
               }
            }

            if(this.field3030 != null) {
               for(var4 = 0; var4 < this.field3030.length; ++var4) {
                  var3.method1564(this.field3030[var4], this.field3021[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1276934755"
   )
   public final Model method3741(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.configs) {
         NPCComposition var12 = this.method3735();
         return var12 == null?null:var12.method3741(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!field3003.method3376(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1559(field3003, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(null != this.field3018) {
               for(var9 = 0; var9 < this.field3018.length; ++var9) {
                  var7.method1526(this.field3018[var9], this.field3019[var9]);
               }
            }

            if(null != this.field3030) {
               for(var9 = 0; var9 < this.field3030.length; ++var9) {
                  var7.method1564(this.field3030[var9], this.field3021[var9]);
               }
            }

            var5 = var7.method1534(this.field3028 + 64, this.field3029 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method3782(var5, var2, var3, var4);
         } else if(null != var1) {
            var11 = var1.method3793(var5, var2);
         } else if(null != var3) {
            var11 = var3.method3793(var5, var4);
         } else {
            var11 = var5.method1614(true);
         }

         if(this.field3025 != 128 || this.field3027 != 128) {
            var11.method1628(this.field3025, this.field3027, this.field3025);
         }

         return var11;
      }
   }
}
