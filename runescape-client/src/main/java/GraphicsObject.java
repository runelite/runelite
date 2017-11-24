import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cy")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -445713033
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2004812179
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -919866899
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -447280355
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 505184409
   )
   @Export("level")
   int level;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1524078873
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1284;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1328806385
   )
   int field1285;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -825993641
   )
   int field1278;
   @ObfuscatedName("r")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1285 = 0;
      this.field1278 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class227.getSpotAnimType(this.id).field3393;
      if(var8 != -1) {
         this.finished = false;
         this.field1284 = class13.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-347160535"
   )
   final void method1721(int var1) {
      if(!this.finished) {
         this.field1278 += var1;

         while(this.field1278 > this.field1284.frameLenghts[this.field1285]) {
            this.field1278 -= this.field1284.frameLenghts[this.field1285];
            ++this.field1285;
            if(this.field1285 >= this.field1284.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   protected final Model getModel() {
      Spotanim var1 = class227.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4494(this.field1285);
      } else {
         var2 = var1.method4494(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lku;S)Ljava/lang/String;",
      garbageValue = "-651"
   )
   public static String method1726(CharSequence var0, class298 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3917) {
               case 3:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var12 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(BufferProvider.method5233(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class274.field3731;
                     int var10 = 0;

                     label102:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class274.field3728;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var11 == var7) {
                                 var8 = true;
                                 break label102;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var11 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9 = class72.method1147(var7);
                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-564400229"
   )
   static Class method1727(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIB)Lfd;",
      garbageValue = "100"
   )
   static class164 method1725(int var0, int var1) {
      Client.field875.field2210 = var0;
      Client.field875.field2211 = var1;
      Client.field875.field2212 = 1;
      Client.field875.field2218 = 1;
      return Client.field875;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1682794608"
   )
   static final void method1724(int var0) {
      WorldMapType2.method529();
      ScriptEvent.method1124();
      VarPlayerType var2 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      VarPlayerType var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var2 = new VarPlayerType();
         if(var3 != null) {
            var2.decode(new Buffer(var3));
         }

         VarPlayerType.varplayers.put(var2, (long)var0);
         var1 = var2;
      }

      int var5 = var1.configType;
      if(var5 != 0) {
         int var6 = class218.widgetSettings[var0];
         if(var5 == 1) {
            if(var6 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var6 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var6 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var6 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            class28.method239();
         }

         if(var5 == 3) {
            short var4 = 0;
            if(var6 == 0) {
               var4 = 255;
            }

            if(var6 == 1) {
               var4 = 192;
            }

            if(var6 == 2) {
               var4 = 128;
            }

            if(var6 == 3) {
               var4 = 64;
            }

            if(var6 == 4) {
               var4 = 0;
            }

            if(var4 != Client.field1113) {
               if(Client.field1113 == 0 && Client.field1090 != -1) {
                  Buffer.method3318(RSCanvas.indexTrack1, Client.field1090, 0, var4, false);
                  Client.field1095 = false;
               } else if(var4 == 0) {
                  Ignore.method1126();
                  Client.field1095 = false;
               } else {
                  ScriptVarType.method29(var4);
               }

               Client.field1113 = var4;
            }
         }

         if(var5 == 4) {
            if(var6 == 0) {
               Client.field1009 = 127;
            }

            if(var6 == 1) {
               Client.field1009 = 96;
            }

            if(var6 == 2) {
               Client.field1009 = 64;
            }

            if(var6 == 3) {
               Client.field1009 = 32;
            }

            if(var6 == 4) {
               Client.field1009 = 0;
            }
         }

         if(var5 == 5) {
            Client.field1021 = var6;
         }

         if(var5 == 6) {
            Client.field1016 = var6;
         }

         if(var5 == 9) {
            Client.field927 = var6;
         }

         if(var5 == 10) {
            if(var6 == 0) {
               Client.field1093 = 127;
            }

            if(var6 == 1) {
               Client.field1093 = 96;
            }

            if(var6 == 2) {
               Client.field1093 = 64;
            }

            if(var6 == 3) {
               Client.field1093 = 32;
            }

            if(var6 == 4) {
               Client.field1093 = 0;
            }
         }

         if(var5 == 17) {
            Client.field1082 = var6 & 65535;
         }

         if(var5 == 18) {
            Client.field897 = (class90)class94.forOrdinal(class45.method664(), var6);
            if(Client.field897 == null) {
               Client.field897 = class90.field1337;
            }
         }

         if(var5 == 19) {
            if(var6 == -1) {
               Client.field1094 = -1;
            } else {
               Client.field1094 = var6 & 2047;
            }
         }

         if(var5 == 22) {
            Client.field898 = (class90)class94.forOrdinal(class45.method664(), var6);
            if(Client.field898 == null) {
               Client.field898 = class90.field1337;
            }
         }

      }
   }
}
