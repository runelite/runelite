import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1041837177
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("p")
   public static IndexDataBase field3608;
   @ObfuscatedName("i")
   public static IndexDataBase field3609;
   @ObfuscatedName("n")
   public static IndexDataBase field3610;
   @ObfuscatedName("f")
   static NodeCache field3611;
   @ObfuscatedName("c")
   int[] field3612;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1857732611
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("z")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("h")
   public int[] field3615;
   @ObfuscatedName("m")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -115122731
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1012631827
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 827199897
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1130775479
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -473968323
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("e")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1900804821
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("j")
   static NodeCache field3625;

   static {
      field3625 = new NodeCache(64);
      field3611 = new NodeCache(100);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "426427263"
   )
   void method4716(Buffer var1, int var2) {
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
         this.field3612 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3612[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3612[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3615 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3615[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "865287612"
   )
   public Model method4718(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class204.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2511(true);
      } else {
         Model var4 = var1.method2511(!var3.method2879(var2));
         var4.method2536(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-1066879169"
   )
   Model method4719(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class204.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2511(true);
      } else {
         Model var5 = var1.method2511(!var4.method2879(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2524();
         } else if(var3 == 2) {
            var5.method2523();
         } else if(var3 == 3) {
            var5.method2522();
         }

         var5.method2536(var4, var2);
         if(var3 == 1) {
            var5.method2522();
         } else if(var3 == 2) {
            var5.method2523();
         } else if(var3 == 3) {
            var5.method2524();
         }

         return var5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IS)LModel;",
      garbageValue = "179"
   )
   public Model method4721(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class204.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4718(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class204.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2511(!var5.method2879(var2));
            var7.method2536(var5, var2);
            return var7;
         } else {
            var7 = var1.method2511(!var5.method2879(var2) & !var6.method2879(var4));
            var7.method2520(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-95"
   )
   public Model method4722(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class204.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2511(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3612 != null && var2 < this.field3612.length) {
            var6 = this.field3612[var2];
            var5 = class204.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2511(!var4.method2879(var3) & !var5.method2879(var6));
            var7.method2536(var4, var3);
            var7.method2536(var5, var6);
            return var7;
         } else {
            var7 = var1.method2511(!var4.method2879(var3));
            var7.method2536(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1034499905"
   )
   void method4729(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4716(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "850791055"
   )
   Model method4731(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class204.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2512(true);
      } else {
         Model var4 = var1.method2512(!var3.method2879(var2));
         var4.method2536(var3, var2);
         return var4;
      }
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1111256011"
   )
   void method4755() {
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
}
