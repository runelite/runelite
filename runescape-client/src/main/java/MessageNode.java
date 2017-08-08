import java.awt.Image;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("az")
   static Image field868;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = 1725085921
   )
   static int field874;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1927186005
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2122038415
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1933766879
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("k")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class99.field1515 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "56"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class99.field1515 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lhg;I)Z",
      garbageValue = "-1053350991"
   )
   static final boolean method1132(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class14.method78(var0, var1);
            int var3 = var0.field2734[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1289194403"
   )
   static File method1133(String var0) {
      if(!class158.field2242) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2240.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2238, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class158.field2240.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-1068823680"
   )
   static void method1130(Buffer var0) {
      if(Client.field950 != null) {
         var0.putBytes(Client.field950, 0, Client.field950.length);
      } else {
         byte[] var1 = class224.method4077();
         var0.putBytes(var1, 0, var1.length);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "-19"
   )
   static int method1125(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class269.field3661:DecorativeObject.field2164;
      if(var0 == 1600) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class84.intStack[++class84.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class84.intStack[++class84.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2644;
         return 1;
      } else if(var0 == 1611) {
         class84.intStack[++class84.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2649;
         return 1;
      } else if(var0 == 1613) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2653.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
