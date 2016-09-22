import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("t")
   @Export("value")
   String value;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1491653587
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("z")
   @Export("sender")
   String sender;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1170256849
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -924079103
   )
   @Export("id")
   int id = class222.method4033();
   @ObfuscatedName("rh")
   protected static String field821;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-421993967"
   )
   void method768(int var1, String var2, String var3, String var4) {
      this.id = class222.method4033();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1134603616"
   )
   static final void method770(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field893 == 0) {
         var0.field897 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = Friend.getAnimation(var0.animation);
            if(var0.field898 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field897;
               return;
            }

            if(var0.field898 <= 0 && var1.field1017 == 0) {
               ++var0.field897;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field843 * 64 + var0.pathX[var0.field893 - 1] * 128;
         int var4 = var0.field843 * 64 + var0.pathY[var0.field893 - 1] * 128;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field891 = 1280;
            } else if(var2 > var4) {
               var0.field891 = 1792;
            } else {
               var0.field891 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field891 = 768;
            } else if(var2 > var4) {
               var0.field891 = 256;
            } else {
               var0.field891 = 512;
            }
         } else if(var2 < var4) {
            var0.field891 = 1024;
         } else if(var2 > var4) {
            var0.field891 = 0;
         }

         byte var5 = var0.field896[var0.field893 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field891 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field887;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field847;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field850;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field863;
            }

            if(var7 == -1) {
               var7 = var0.field847;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field891 != var0.angle && var0.interacting == -1 && var0.field892 != 0) {
                  var8 = 2;
               }

               if(var0.field893 > 2) {
                  var8 = 6;
               }

               if(var0.field893 > 3) {
                  var8 = 8;
               }

               if(var0.field897 > 0 && var0.field893 > 1) {
                  var8 = 8;
                  --var0.field897;
               }
            } else {
               if(var0.field893 > 1) {
                  var8 = 6;
               }

               if(var0.field893 > 2) {
                  var8 = 8;
               }

               if(var0.field897 > 0 && var0.field893 > 1) {
                  var8 = 8;
                  --var0.field897;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field847 == var0.poseAnimation && var0.field851 != -1) {
               var0.poseAnimation = var0.field851;
            }

            if(var10 != var3 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var0.y == var4) {
               --var0.field893;
               if(var0.field898 > 0) {
                  --var0.field898;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field893;
            if(var0.field898 > 0) {
               --var0.field898;
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "43"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1181.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1179.method3309(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1129();
         if(var1.field1219 != -1) {
            var1.method1122(getItemDefinition(var1.field1219), getItemDefinition(var1.note));
         }

         if(var1.field1226 != -1) {
            var1.method1123(getItemDefinition(var1.field1226), getItemDefinition(var1.field1225));
         }

         if(var1.field1184 != -1) {
            var1.method1148(getItemDefinition(var1.field1184), getItemDefinition(var1.field1227));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1191 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1223 = 0;
         }

         ItemComposition.field1181.put(var1, (long)var0);
         return var1;
      }
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1398268118"
   )
   static int method773(int var0) {
      MessageNode var1 = (MessageNode)class11.field166.method3836((long)var0);
      return null == var1?-1:(var1.next == class11.field167.field3154?-1:((MessageNode)var1.next).id);
   }
}
