import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3565;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3547;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -190552419
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ag")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("g")
   @Export("name")
   public String name;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -83714373
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("w")
   int[] field3545;
   @ObfuscatedName("l")
   @Export("models")
   int[] models;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 436113289
   )
   @Export("id")
   public int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -414784307
   )
   public int field3543;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2101555175
   )
   public int field3553;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1206560479
   )
   public int field3549;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1337653189
   )
   public int field3563;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 642503267
   )
   public int field3548;
   @ObfuscatedName("z")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1409702733
   )
   int field3560;
   @ObfuscatedName("a")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("u")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -462335669
   )
   int field3561;
   @ObfuscatedName("t")
   short[] field3555;
   @ObfuscatedName("v")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 701149107
   )
   public int field3550;
   @ObfuscatedName("y")
   short[] field3558;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1059472205
   )
   public int field3551;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -864193395
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("d")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 765380839
   )
   int field3556;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2046803715
   )
   public int field3546;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1298939383
   )
   int field3564;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1668469373
   )
   public int field3540;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1041143623
   )
   public int field3566;
   @ObfuscatedName("aj")
   public boolean field3570;
   @ObfuscatedName("ae")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("at")
   public boolean field3572;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3543 = 1;
      this.field3553 = -1;
      this.field3563 = -1;
      this.field3548 = -1;
      this.field3549 = -1;
      this.field3550 = -1;
      this.field3551 = -1;
      this.field3546 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3560 = 128;
      this.field3561 = 128;
      this.isVisible = false;
      this.field3556 = 0;
      this.field3564 = 0;
      this.field3540 = -1;
      this.field3566 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3570 = true;
      this.isClickable = true;
      this.field3572 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lim;",
      garbageValue = "-1663831699"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = BaseVarType.method12(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class212.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class183.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-1825895466"
   )
   void method4667(Buffer var1, int var2) {
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
         this.field3543 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3553 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3549 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3563 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3548 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3549 = var1.readUnsignedShort();
         this.field3550 = var1.readUnsignedShort();
         this.field3551 = var1.readUnsignedShort();
         this.field3546 = var1.readUnsignedShort();
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
         this.field3555 = new short[var3];
         this.field3558 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3555[var4] = (short)var1.readUnsignedShort();
            this.field3558[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3545 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3545[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3560 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3561 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3556 = var1.readByte();
      } else if(var2 == 101) {
         this.field3564 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3540 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3566 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3570 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3572 = true;
         } else if(var2 == 249) {
            this.field3547 = FileRequest.method4109(var1, this.field3547);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldi;",
      garbageValue = "-117"
   )
   public final ModelData method4669() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4669();
      } else if(this.field3545 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3545.length; ++var2) {
            if(!field3565.method4115(this.field3545[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3545.length];

            for(int var3 = 0; var3 < this.field3545.length; ++var3) {
               var6[var3] = ModelData.method2431(field3565, this.field3545[var3], 0);
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

            if(this.field3555 != null) {
               for(var4 = 0; var4 < this.field3555.length; ++var4) {
                  var7.method2446(this.field3555[var4], this.field3558[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljf;ILjf;II)Leo;",
      garbageValue = "-1736466063"
   )
   public final Model method4668(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4668(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3565.method4115(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2431(field3565, this.models[var9], 0);
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

            if(this.field3555 != null) {
               for(var9 = 0; var9 < this.field3555.length; ++var9) {
                  var11.method2446(this.field3555[var9], this.field3558[var9]);
               }
            }

            var5 = var11.light(this.field3556 + 64, this.field3564 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4733(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4720(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4720(var5, var4);
         } else {
            var10 = var5.method2525(true);
         }

         if(this.field3560 != 128 || this.field3561 != 128) {
            var10.method2539(this.field3560, this.field3561, this.field3560);
         }

         return var10;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "805549076"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4667(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method4671() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = BaseVarType.method12(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class212.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "166180392"
   )
   public int method4672(int var1, int var2) {
      return ChatLineBuffer.method1892(this.field3547, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "285883296"
   )
   public String method4673(int var1, String var2) {
      return class29.method261(this.field3547, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lja;",
      garbageValue = "-506752944"
   )
   public static Overlay method4664(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class250.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }
}
