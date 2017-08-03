import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3557;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3565;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2047864859
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ag")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("f")
   @Export("name")
   public String name;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1387752579
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("i")
   int[] field3537;
   @ObfuscatedName("t")
   @Export("models")
   int[] models;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1803863717
   )
   @Export("id")
   public int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 405438765
   )
   public int field3535;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 970387119
   )
   public int field3563;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 954191
   )
   public int field3541;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 193711199
   )
   public int field3539;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1917721297
   )
   public int field3531;
   @ObfuscatedName("l")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -586703475
   )
   int field3552;
   @ObfuscatedName("w")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1504282725
   )
   int field3562;
   @ObfuscatedName("m")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("n")
   short[] field3547;
   @ObfuscatedName("k")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -553387927
   )
   public int field3538;
   @ObfuscatedName("c")
   short[] field3548;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1457171405
   )
   public int field3543;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 134709399
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("j")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 765010023
   )
   int field3555;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1275337749
   )
   public int field3544;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -962951087
   )
   int field3556;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1245743707
   )
   public int field3534;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1242396023
   )
   public int field3558;
   @ObfuscatedName("ai")
   public boolean field3542;
   @ObfuscatedName("au")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ad")
   public boolean field3564;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3535 = 1;
      this.field3563 = -1;
      this.field3539 = -1;
      this.field3531 = -1;
      this.field3541 = -1;
      this.field3538 = -1;
      this.field3543 = -1;
      this.field3544 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3552 = 128;
      this.field3562 = 128;
      this.isVisible = false;
      this.field3555 = 0;
      this.field3556 = 0;
      this.field3534 = -1;
      this.field3558 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3542 = true;
      this.isClickable = true;
      this.field3564 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)Lin;",
      garbageValue = "13083"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class90.method1720(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class211.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class60.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "1844491396"
   )
   void method4619(Buffer var1, int var2) {
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
         this.field3535 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3563 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3541 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3539 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3531 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3541 = var1.readUnsignedShort();
         this.field3538 = var1.readUnsignedShort();
         this.field3543 = var1.readUnsignedShort();
         this.field3544 = var1.readUnsignedShort();
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
         this.field3547 = new short[var3];
         this.field3548 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3547[var4] = (short)var1.readUnsignedShort();
            this.field3548[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3537 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3537[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3552 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3562 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3555 = var1.readByte();
      } else if(var2 == 101) {
         this.field3556 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3534 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3558 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3542 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3564 = true;
         } else if(var2 == 249) {
            this.field3565 = FrameMap.method2698(var1, this.field3565);
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "40"
   )
   public final ModelData method4620() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4620();
      } else if(this.field3537 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3537.length; ++var2) {
            if(!field3557.method4115(this.field3537[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3537.length];

            for(int var3 = 0; var3 < this.field3537.length; ++var3) {
               var6[var3] = ModelData.method2477(field3557, this.field3537[var3], 0);
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

            if(this.field3547 != null) {
               for(var4 = 0; var4 < this.field3547.length; ++var4) {
                  var7.method2429(this.field3547[var4], this.field3548[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;II)Lev;",
      garbageValue = "2105618571"
   )
   public final Model method4627(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4627(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3557.method4115(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2477(field3557, this.models[var9], 0);
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

            if(this.field3547 != null) {
               for(var9 = 0; var9 < this.field3547.length; ++var9) {
                  var11.method2429(this.field3547[var9], this.field3548[var9]);
               }
            }

            var5 = var11.light(this.field3555 + 64, this.field3556 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4685(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4682(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4682(var5, var4);
         } else {
            var10 = var5.method2505(true);
         }

         if(this.field3552 != 128 || this.field3562 != 128) {
            var10.method2521(this.field3552, this.field3562, this.field3552);
         }

         return var10;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1110583225"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-89453377"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4619(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "743332851"
   )
   public boolean method4625() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class90.method1720(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class211.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1672052422"
   )
   public int method4621(int var1, int var2) {
      return class56.method835(this.field3565, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-56"
   )
   public String method4622(int var1, String var2) {
      return class33.method356(this.field3565, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2138444319"
   )
   public static void method4657() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field704 = MouseInput.field701 * -359621811;
         MouseInput.field696 = MouseInput.mouseX;
         MouseInput.field705 = MouseInput.mouseY;
         MouseInput.field697 = MouseInput.field707;
         MouseInput.field709 = MouseInput.field708;
         MouseInput.field713 = MouseInput.field711;
         MouseInput.field714 = MouseInput.field702;
         MouseInput.field707 = 0;
      }
   }
}
