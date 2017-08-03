import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -648556621
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("f")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("g")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -395082515
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1720558511
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("t")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("s")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2133742857
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -222050583
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   int[] field3586;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1267720669
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -560020567
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1200432677
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("i")
   public int[] field3596;

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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-789007591"
   )
   void method4680(Buffer var1, int var2) {
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
         this.field3586 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3586[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3586[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3596 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3596[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lev;IB)Lev;",
      garbageValue = "0"
   )
   public Model method4682(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = FaceNormal.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2505(true);
      } else {
         Model var4 = var1.method2505(!var3.method2905(var2));
         var4.method2518(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lev;ILjj;II)Lev;",
      garbageValue = "-1934166363"
   )
   public Model method4685(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = FaceNormal.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4682(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = FaceNormal.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2505(!var5.method2905(var2));
            var7.method2518(var5, var2);
            return var7;
         } else {
            var7 = var1.method2505(!var5.method2905(var2) & !var6.method2905(var4));
            var7.method2514(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lev;IIS)Lev;",
      garbageValue = "63"
   )
   Model method4683(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = FaceNormal.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2505(true);
      } else {
         Model var5 = var1.method2505(!var4.method2905(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2541();
         } else if(var3 == 2) {
            var5.method2580();
         } else if(var3 == 3) {
            var5.method2516();
         }

         var5.method2518(var4, var2);
         if(var3 == 1) {
            var5.method2516();
         } else if(var3 == 2) {
            var5.method2580();
         } else if(var3 == 3) {
            var5.method2541();
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lev;II)Lev;",
      garbageValue = "1755060415"
   )
   Model method4688(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = FaceNormal.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2527(true);
      } else {
         Model var4 = var1.method2527(!var3.method2905(var2));
         var4.method2518(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lev;II)Lev;",
      garbageValue = "-1657609920"
   )
   public Model method4686(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = FaceNormal.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2505(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3586 != null && var2 < this.field3586.length) {
            var6 = this.field3586[var2];
            var5 = FaceNormal.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2505(!var4.method2905(var3) & !var5.method2905(var6));
            var7.method2518(var4, var3);
            var7.method2518(var5, var6);
            return var7;
         } else {
            var7 = var1.method2505(!var4.method2905(var3));
            var7.method2518(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-924550885"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-2017933818"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4680(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1186790578"
   )
   public static String method4712(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
