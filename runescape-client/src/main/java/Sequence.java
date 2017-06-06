import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1519255351
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -987883479
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("y")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("c")
   static IndexDataBase field3600;
   @ObfuscatedName("b")
   static NodeCache field3601;
   @ObfuscatedName("i")
   static IndexDataBase field3602;
   @ObfuscatedName("h")
   int[] field3603;
   @ObfuscatedName("x")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("f")
   public int[] field3605;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -805558303
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("a")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 647428467
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("e")
   static IndexDataBase field3610;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -883996047
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1589901293
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 268279351
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -559003979
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("v")
   static NodeCache field3616;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1571302135"
   )
   void method4686(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4687(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1283075768"
   )
   void method4687(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3603 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3603[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3603[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3605 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3605[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1827585780"
   )
   public Model method4689(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class224.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2541(true);
      } else {
         Model var4 = var1.method2541(!var3.method2869(var2));
         var4.method2499(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1574582138"
   )
   Model method4690(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class224.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2541(true);
      } else {
         Model var5 = var1.method2541(!var4.method2869(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2490();
         } else if(var3 == 2) {
            var5.method2505();
         } else if(var3 == 3) {
            var5.method2502();
         }

         var5.method2499(var4, var2);
         if(var3 == 1) {
            var5.method2502();
         } else if(var3 == 2) {
            var5.method2505();
         } else if(var3 == 3) {
            var5.method2490();
         }

         return var5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "1351377975"
   )
   public Model method4692(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class224.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4689(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class224.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2541(!var5.method2869(var2));
            var7.method2499(var5, var2);
            return var7;
         } else {
            var7 = var1.method2541(!var5.method2869(var2) & !var6.method2869(var4));
            var7.method2493(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1855717730"
   )
   public Model method4693(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class224.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2541(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3603 != null && var2 < this.field3603.length) {
            var6 = this.field3603[var2];
            var5 = class224.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2541(!var4.method2869(var3) & !var5.method2869(var6));
            var7.method2499(var4, var3);
            var7.method2499(var5, var6);
            return var7;
         } else {
            var7 = var1.method2541(!var4.method2869(var3));
            var7.method2499(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "594704424"
   )
   Model method4696(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class224.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2515(true);
      } else {
         Model var4 = var1.method2515(!var3.method2869(var2));
         var4.method2499(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method4698() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   static {
      field3616 = new NodeCache(64);
      field3601 = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }
}
