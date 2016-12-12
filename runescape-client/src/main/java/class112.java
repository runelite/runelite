import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public abstract class class112 {
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 834078751
   )
   protected static int field1755;
   @ObfuscatedName("l")
   public static class60 field1760;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2087039052"
   )
   public abstract void vmethod2056(Component var1);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "917686579"
   )
   public abstract int vmethod2057();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-9495"
   )
   public abstract void vmethod2058(Component var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   static void method2067() {
      int var0;
      if(Client.field311 == 0) {
         Client.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class159.field2131 = new SpritePixels(512, 512);
         class41.field843 = "Starting game engine...";
         class41.field842 = 5;
         Client.field311 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field311 == 20) {
            int[] var28 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + var1 * 32 + 128;
               var3 = 3 * var2 + 600;
               var4 = class84.field1453[var2];
               var28[var1] = var4 * var3 >> 16;
            }

            Region.method1726(var28, 500, 800, 512, 334);
            class41.field843 = "Prepared visibility map";
            class41.field842 = 10;
            Client.field311 = 30;
         } else if(Client.field311 == 30) {
            class137.field1897 = class38.method707(0, false, true, true);
            class44.field900 = class38.method707(1, false, true, true);
            Friend.field152 = class38.method707(2, true, false, true);
            class47.field947 = class38.method707(3, false, true, true);
            VertexNormal.field1425 = class38.method707(4, false, true, true);
            Friend.field150 = class38.method707(5, true, true, true);
            class204.field3079 = class38.method707(6, true, true, false);
            class140.field1974 = class38.method707(7, false, true, true);
            Client.field314 = class38.method707(8, false, true, true);
            MessageNode.field220 = class38.method707(9, false, true, true);
            CollisionData.field1838 = class38.method707(10, false, true, true);
            class105.field1706 = class38.method707(11, false, true, true);
            class65.field1111 = class38.method707(12, false, true, true);
            CollisionData.field1837 = class38.method707(13, true, false, true);
            class180.field2696 = class38.method707(14, false, true, false);
            class0.field7 = class38.method707(15, false, true, true);
            class41.field843 = "Connecting to update server";
            class41.field842 = 20;
            Client.field311 = 40;
         } else if(Client.field311 == 40) {
            byte var24 = 0;
            var0 = var24 + class137.field1897.method3317() * 4 / 100;
            var0 += class44.field900.method3317() * 4 / 100;
            var0 += Friend.field152.method3317() * 2 / 100;
            var0 += class47.field947.method3317() * 2 / 100;
            var0 += VertexNormal.field1425.method3317() * 6 / 100;
            var0 += Friend.field150.method3317() * 4 / 100;
            var0 += class204.field3079.method3317() * 2 / 100;
            var0 += class140.field1974.method3317() * 60 / 100;
            var0 += Client.field314.method3317() * 2 / 100;
            var0 += MessageNode.field220.method3317() * 2 / 100;
            var0 += CollisionData.field1838.method3317() * 2 / 100;
            var0 += class105.field1706.method3317() * 2 / 100;
            var0 += class65.field1111.method3317() * 2 / 100;
            var0 += CollisionData.field1837.method3317() * 2 / 100;
            var0 += class180.field2696.method3317() * 2 / 100;
            var0 += class0.field7.method3317() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field843 = "Checking for updates - " + var0 + "%";
               }

               class41.field842 = 30;
            } else {
               class41.field843 = "Loaded update list";
               class41.field842 = 30;
               Client.field311 = 45;
            }
         } else {
            class184 var18;
            class184 var19;
            if(Client.field311 == 45) {
               boolean var23 = !Client.field289;
               class57.field1053 = 22050;
               class57.field1062 = var23;
               class57.field1056 = 2;
               class139 var25 = new class139();
               var25.method2498(9, 128);
               Client.field568 = class2.method25(class41.field855, class110.canvas, 0, 22050);
               Client.field568.method1015(var25);
               var18 = class0.field7;
               class184 var20 = class180.field2696;
               var19 = VertexNormal.field1425;
               class138.field1919 = var18;
               class138.field1918 = var20;
               class138.field1912 = var19;
               class138.field1913 = var25;
               class104.field1680 = class2.method25(class41.field855, class110.canvas, 1, 2048);
               class0.field3 = new class51();
               class104.field1680.method1015(class0.field3);
               MessageNode.field229 = new class65(22050, class57.field1053);
               class41.field843 = "Prepared sound engine";
               class41.field842 = 35;
               Client.field311 = 50;
            } else if(Client.field311 == 50) {
               var0 = 0;
               if(RSCanvas.field1753 == null) {
                  RSCanvas.field1753 = Player.method236(Client.field314, CollisionData.field1837, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class40.field821 == null) {
                  class40.field821 = Player.method236(Client.field314, CollisionData.field1837, "p12_full", "");
               } else {
                  ++var0;
               }

               if(class11.field119 == null) {
                  class11.field119 = Player.method236(Client.field314, CollisionData.field1837, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field843 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class41.field842 = 40;
               } else {
                  class180.field2695 = new class230(true);
                  class41.field843 = "Loaded fonts";
                  class41.field842 = 40;
                  Client.field311 = 60;
               }
            } else {
               class184 var16;
               if(Client.field311 == 60) {
                  var16 = CollisionData.field1838;
                  var18 = Client.field314;
                  var3 = 0;
                  if(var16.method3208("title.jpg", "")) {
                     ++var3;
                  }

                  if(var18.method3208("logo", "")) {
                     ++var3;
                  }

                  if(var18.method3208("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var18.method3208("titlebox", "")) {
                     ++var3;
                  }

                  if(var18.method3208("titlebutton", "")) {
                     ++var3;
                  }

                  if(var18.method3208("runes", "")) {
                     ++var3;
                  }

                  if(var18.method3208("title_mute", "")) {
                     ++var3;
                  }

                  if(var18.method3229("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var18.method3229("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var18.method3208("sl_back", "");
                  var18.method3208("sl_flags", "");
                  var18.method3208("sl_arrows", "");
                  var18.method3208("sl_stars", "");
                  var18.method3208("sl_button", "");
                  var4 = Frames.method1870();
                  if(var3 < var4) {
                     class41.field843 = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class41.field842 = 50;
                  } else {
                     class41.field843 = "Loaded title screen";
                     class41.field842 = 50;
                     XGrandExchangeOffer.setGameState(5);
                     Client.field311 = 70;
                  }
               } else if(Client.field311 == 70) {
                  if(!Friend.field152.method3215()) {
                     class41.field843 = "Loading config - " + Friend.field152.method3325() + "%";
                     class41.field842 = 60;
                  } else {
                     MessageNode.method203(Friend.field152);
                     class184 var27 = Friend.field152;
                     class191.field2813 = var27;
                     class3.method36(Friend.field152, class140.field1974);
                     var16 = Friend.field152;
                     var18 = class140.field1974;
                     boolean var22 = Client.field289;
                     class207.field3089 = var16;
                     ObjectComposition.field2893 = var18;
                     ObjectComposition.field2900 = var22;
                     var19 = Friend.field152;
                     class184 var21 = class140.field1974;
                     NPCComposition.field3004 = var19;
                     NPCComposition.field2999 = var21;
                     DecorativeObject.method1893(Friend.field152, class140.field1974, Client.isMembers, RSCanvas.field1753);
                     Client.method553(Friend.field152, class137.field1897, class44.field900);
                     class164.method3055(Friend.field152, class140.field1974);
                     class31.method649(Friend.field152);
                     class184 var6 = Friend.field152;
                     class187.field2775 = var6;
                     class187.field2779 = class187.field2775.method3220(16);
                     class184 var7 = class47.field947;
                     class184 var8 = class140.field1974;
                     class184 var9 = Client.field314;
                     class184 var10 = CollisionData.field1837;
                     Widget.field2199 = var7;
                     Widget.field2200 = var8;
                     Widget.field2201 = var9;
                     class174.field2643 = var10;
                     Widget.widgets = new Widget[Widget.field2199.method3221()][];
                     Widget.validInterfaces = new boolean[Widget.field2199.method3221()];
                     class184 var11 = Friend.field152;
                     class186.field2774 = var11;
                     class184 var12 = Friend.field152;
                     class195.field2861 = var12;
                     class3.method28(Friend.field152);
                     class184 var13 = Friend.field152;
                     class189.field2787 = var13;
                     Ignore.chatMessages = new ChatMessages();
                     class167.method3089(Friend.field152, Client.field314, CollisionData.field1837);
                     class184 var14 = Friend.field152;
                     class184 var15 = Client.field314;
                     CombatInfo2.field2832 = var14;
                     CombatInfo2.field2831 = var15;
                     class41.field843 = "Loaded config";
                     class41.field842 = 60;
                     Client.field311 = 80;
                  }
               } else if(Client.field311 != 80) {
                  if(Client.field311 == 90) {
                     if(!MessageNode.field220.method3215()) {
                        class41.field843 = "Loading textures - " + MessageNode.field220.method3325() + "%";
                        class41.field842 = 90;
                     } else {
                        TextureProvider var26 = new TextureProvider(MessageNode.field220, Client.field314, 20, 0.8D, Client.field289?64:128);
                        class84.method1628(var26);
                        class84.method1667(0.8D);
                        class41.field843 = "Loaded textures";
                        class41.field842 = 90;
                        Client.field311 = 110;
                     }
                  } else if(Client.field311 == 110) {
                     class26.field596 = new class20();
                     class41.field855.method1932(class26.field596, 10);
                     class41.field843 = "Loaded input handler";
                     class41.field842 = 94;
                     Client.field311 = 120;
                  } else if(Client.field311 == 120) {
                     if(!CollisionData.field1838.method3208("huffman", "")) {
                        class41.field843 = "Loading wordpack - " + 0 + "%";
                        class41.field842 = 96;
                     } else {
                        class145 var17 = new class145(CollisionData.field1838.method3228("huffman", ""));
                        class210.field3114 = var17;
                        class41.field843 = "Loaded wordpack";
                        class41.field842 = 96;
                        Client.field311 = 130;
                     }
                  } else if(Client.field311 == 130) {
                     if(!class47.field947.method3215()) {
                        class41.field843 = "Loading interfaces - " + class47.field947.method3325() * 4 / 5 + "%";
                        class41.field842 = 100;
                     } else if(!class65.field1111.method3215()) {
                        class41.field843 = "Loading interfaces - " + (80 + class65.field1111.method3325() / 6) + "%";
                        class41.field842 = 100;
                     } else if(!CollisionData.field1837.method3215()) {
                        class41.field843 = "Loading interfaces - " + (96 + CollisionData.field1837.method3325() / 20) + "%";
                        class41.field842 = 100;
                     } else {
                        class41.field843 = "Loaded interfaces";
                        class41.field842 = 100;
                        Client.field311 = 140;
                     }
                  } else if(Client.field311 == 140) {
                     XGrandExchangeOffer.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  if(class178.field2678 == null) {
                     class178.field2678 = class157.method2970(Client.field314, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class63.field1095 == null) {
                     class63.field1095 = class157.method2970(Client.field314, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class168.field2195 == null) {
                     class168.field2195 = class15.method175(Client.field314, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class44.field898 == null) {
                     class44.field898 = class57.method1024(Client.field314, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == Frames.field1563) {
                     Frames.field1563 = class57.method1024(Client.field314, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(XClanMember.field273 == null) {
                     XClanMember.field273 = class57.method1024(Client.field314, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class9.field85 == null) {
                     class9.field85 = class57.method1024(Client.field314, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class142.field1992 == null) {
                     class142.field1992 = class57.method1024(Client.field314, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class15.field162 == null) {
                     class15.field162 = class57.method1024(Client.field314, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class13.field130) {
                     class13.field130 = class57.method1024(Client.field314, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class9.field81 == null) {
                     class9.field81 = class15.method175(Client.field314, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(null == XItemContainer.field128) {
                     XItemContainer.field128 = class15.method175(Client.field314, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class41.field843 = "Loading sprites - " + 100 * var0 / 12 + "%";
                     class41.field842 = 70;
                  } else {
                     class209.modIcons = XItemContainer.field128;
                     class63.field1095.method4108();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(int var5 = 0; var5 < class44.field898.length; ++var5) {
                        class44.field898[var5].method4076(var4 + var1, var4 + var2, var3 + var4);
                     }

                     class168.field2195[0].method3980(var1 + var4, var2 + var4, var4 + var3);
                     class41.field843 = "Loaded sprites";
                     class41.field842 = 70;
                     Client.field311 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-982223580"
   )
   static final void method2068(String var0) {
      if(var0 != null) {
         String var1 = class118.method2244(var0, class108.field1724);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class118.method2244(var4, class108.field1724);
               boolean var6;
               if(null != var0 && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[1 + var7];
                  }

                  Client.field479 = Client.field471;
                  Client.field294.method2976(163);
                  Client.field294.method2932(class57.method1067(var0));
                  Client.field294.method2757(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "100"
   )
   public static void method2069(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3228.method2326();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2748(var1.field3219);

         for(int var3 = 0; var3 < var1.field3226; ++var3) {
            if(var1.field3220[var3] != 0) {
               var0.method2932(var1.field3220[var3]);
            } else {
               try {
                  int var4 = var1.field3221[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2932(0);
                     var0.method2748(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3224[var3]);
                     var0.method2932(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2932(0);
                     var0.method2748(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2932(0);
                        var0.method2748(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(null == var11) {
                        var0.method2932(0);
                     } else if(var11 instanceof Number) {
                        var0.method2932(1);
                        var0.method2919(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2932(2);
                        var0.method2757((String)var11);
                     } else {
                        var0.method2932(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2932(-10);
               } catch (InvalidClassException var14) {
                  var0.method2932(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2932(-12);
               } catch (OptionalDataException var16) {
                  var0.method2932(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2932(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2932(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2932(-16);
               } catch (SecurityException var20) {
                  var0.method2932(-17);
               } catch (IOException var21) {
                  var0.method2932(-18);
               } catch (NullPointerException var22) {
                  var0.method2932(-19);
               } catch (Exception var23) {
                  var0.method2932(-20);
               } catch (Throwable var24) {
                  var0.method2932(-21);
               }
            }
         }

         var0.method2781(var2);
         var1.unlink();
      }
   }
}
