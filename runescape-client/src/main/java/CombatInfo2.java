import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3346;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3356;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3344;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static class13 field3350;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1936696281
   )
   int field3352;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -440222131
   )
   int field3353;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1896612393
   )
   public int field3347;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 619530267
   )
   public int field3349;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -703630041
   )
   public int field3348;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 920788083
   )
   public int field3343;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -962959665
   )
   public int field3342;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -3724405
   )
   public int field3351;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 971962533
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -347693843
   )
   public int field3355;

   static {
      field3346 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3347 = 255;
      this.field3348 = 255;
      this.field3349 = -1;
      this.field3342 = 1;
      this.field3343 = 70;
      this.field3352 = -1;
      this.field3353 = -1;
      this.healthScale = 30;
      this.field3355 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-2004948004"
   )
   void method4366(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3347 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3348 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3349 = 0;
      } else if(var2 == 5) {
         this.field3343 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3352 = var1.method3216();
      } else if(var2 == 8) {
         this.field3353 = var1.method3216();
      } else if(var2 == 11) {
         this.field3349 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3355 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "65"
   )
   public void method4365(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4366(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Lji;",
      garbageValue = "93"
   )
   public SpritePixels method4368() {
      if(this.field3353 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3353);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3344, this.field3353, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3353);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lji;",
      garbageValue = "1465264572"
   )
   public SpritePixels method4367() {
      if(this.field3352 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3352);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3344, this.field3352, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3352);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1099570107"
   )
   static final void method4384(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1101 == 1) && Client.friendCount < 400) {
            String var1 = class9.method48(var0, MouseInput.field715);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class9.method48(var3.name, MouseInput.field715);
                  if(var4 != null && var4.equals(var1)) {
                     class202.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class9.method48(var3.previousName, MouseInput.field715);
                     if(var5 != null && var5.equals(var1)) {
                        class202.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class9.method48(var6.name, MouseInput.field715);
                  if(var4 != null && var4.equals(var1)) {
                     class202.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class9.method48(var6.previousName, MouseInput.field715);
                     if(var5 != null && var5.equals(var1)) {
                        class202.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class9.method48(class224.localPlayer.name, MouseInput.field715).equals(var1)) {
                  class202.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(243);
                  Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            class202.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
