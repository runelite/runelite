import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3544;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3562;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 488176719
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("av")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1580818857
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("p")
   int[] field3534;
   @ObfuscatedName("x")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1148227109
   )
   @Export("id")
   public int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -687118125
   )
   public int field3532;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -589262859
   )
   public int field3547;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1127204661
   )
   public int field3538;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 59054491
   )
   public int field3550;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 383804227
   )
   public int field3537;
   @ObfuscatedName("f")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 925717821
   )
   int field3549;
   @ObfuscatedName("e")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2064723313
   )
   int field3553;
   @ObfuscatedName("j")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("l")
   short[] field3528;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1701709497
   )
   public int field3539;
   @ObfuscatedName("y")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("q")
   short[] field3545;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1757513917
   )
   public int field3540;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1025254519
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("d")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1772252145
   )
   public int field3541;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -539789599
   )
   int field3536;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1250833881
   )
   int field3529;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1292264621
   )
   public int field3554;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1646780603
   )
   public int field3555;
   @ObfuscatedName("af")
   public boolean field3559;
   @ObfuscatedName("ak")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ar")
   public boolean field3533;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3532 = 1;
      this.field3547 = -1;
      this.field3550 = -1;
      this.field3537 = -1;
      this.field3538 = -1;
      this.field3539 = -1;
      this.field3540 = -1;
      this.field3541 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3549 = 128;
      this.field3553 = 128;
      this.isVisible = false;
      this.field3536 = 0;
      this.field3529 = 0;
      this.field3554 = -1;
      this.field3555 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3559 = true;
      this.isClickable = true;
      this.field3533 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lib;",
      garbageValue = "-36"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class17.method125(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class211.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?WorldMapType3.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-974730324"
   )
   void method4513(Buffer var1, int var2) {
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
         this.field3532 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3547 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3538 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3550 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3537 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3538 = var1.readUnsignedShort();
         this.field3539 = var1.readUnsignedShort();
         this.field3540 = var1.readUnsignedShort();
         this.field3541 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3528 = new short[var3];
         this.field3545 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3528[var4] = (short)var1.readUnsignedShort();
            this.field3545[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3534 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3534[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3549 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3553 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3536 = var1.readByte();
      } else if(var2 == 101) {
         this.field3529 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3554 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3555 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3559 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3533 = true;
         } else if(var2 == 249) {
            this.field3562 = class46.method629(var1, this.field3562);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == '\uffff') {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == '\uffff') {
            this.varp32Index = -1;
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

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldj;",
      garbageValue = "1"
   )
   public final ModelData method4515() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4515();
      } else if(this.field3534 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3534.length; ++var2) {
            if(!class140.field2081.method4010(this.field3534[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3534.length];

            for(int var3 = 0; var3 < this.field3534.length; ++var3) {
               var6[var3] = ModelData.method2331(class140.field2081, this.field3534[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.field3528 != null) {
               for(var4 = 0; var4 < this.field3528.length; ++var4) {
                  var7.method2347(this.field3528[var4], this.field3545[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljc;ILjc;II)Leo;",
      garbageValue = "-731739691"
   )
   public final Model method4514(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4514(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!class140.field2081.method4010(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2331(class140.field2081, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  var11.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.field3528 != null) {
               for(var9 = 0; var9 < this.field3528.length; ++var9) {
                  var11.method2347(this.field3528[var9], this.field3545[var9]);
               }
            }

            var5 = var11.light(this.field3536 + 64, this.field3529 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4582(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4583(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4583(var5, var4);
         } else {
            var10 = var5.method2429(true);
         }

         if(this.field3549 != 128 || this.field3553 != 128) {
            var10.method2487(this.field3549, this.field3553, this.field3549);
         }

         return var10;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "28"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4513(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1997334001"
   )
   public boolean method4512() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class17.method125(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class211.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2041595573"
   )
   public String method4519(int var1, String var2) {
      return class232.method4001(this.field3562, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-501976772"
   )
   public int method4524(int var1, int var2) {
      return class112.method2023(this.field3562, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lip;III)Ljj;",
      garbageValue = "1335163004"
   )
   public static SpritePixels method4549(IndexDataBase var0, int var1, int var2) {
      return !ISAACCipher.method3381(var0, var1, var2)?null:class61.method1019();
   }
}
