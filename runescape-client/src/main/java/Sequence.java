import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 103671751
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("n")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("d")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 666848973
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -410403487
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("b")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("l")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 148411523
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 115573401
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("q")
   int[] field3610;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2111475813
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1332044497
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -408727885
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("k")
   public int[] field3599;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-291835794"
   )
   void method4664(Buffer var1, int var2) {
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
         this.field3610 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3610[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3610[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3599 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3599[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lem;IB)Lem;",
      garbageValue = "-18"
   )
   public Model method4667(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2511(true);
      } else {
         Model var4 = var1.method2511(!var3.method2919(var2));
         var4.method2519(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lem;ILjw;IB)Lem;",
      garbageValue = "-128"
   )
   public Model method4670(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4667(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class150.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2511(!var5.method2919(var2));
            var7.method2519(var5, var2);
            return var7;
         } else {
            var7 = var1.method2511(!var5.method2919(var2) & !var6.method2919(var4));
            var7.method2520(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lem;IIB)Lem;",
      garbageValue = "0"
   )
   Model method4668(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2511(true);
      } else {
         Model var5 = var1.method2511(!var4.method2919(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2587();
         } else if(var3 == 2) {
            var5.method2523();
         } else if(var3 == 3) {
            var5.method2509();
         }

         var5.method2519(var4, var2);
         if(var3 == 1) {
            var5.method2509();
         } else if(var3 == 2) {
            var5.method2523();
         } else if(var3 == 3) {
            var5.method2587();
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lem;II)Lem;",
      garbageValue = "-1417249368"
   )
   Model method4669(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2530(true);
      } else {
         Model var4 = var1.method2530(!var3.method2919(var2));
         var4.method2519(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lem;IB)Lem;",
      garbageValue = "1"
   )
   public Model method4671(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class150.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2511(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3610 != null && var2 < this.field3610.length) {
            var6 = this.field3610[var2];
            var5 = class150.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2511(!var4.method2919(var3) & !var5.method2919(var6));
            var7.method2519(var4, var3);
            var7.method2519(var5, var6);
            return var7;
         } else {
            var7 = var1.method2511(!var4.method2919(var3));
            var7.method2519(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-318392113"
   )
   @Export("post")
   void post() {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1202369518"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4664(var1, var2);
      }
   }
}
