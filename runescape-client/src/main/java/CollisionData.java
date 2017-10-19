import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("fw")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 145261967
   )
   @Export("width")
   int width;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -628535809
   )
   @Export("x")
   int x;
   @ObfuscatedName("al")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1235042947
   )
   @Export("height")
   int height;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 231900507
   )
   @Export("y")
   int y;

   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2035877143"
   )
   @Export("remove")
   void remove(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "255"
   )
   @Export("add")
   void add(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1826334910"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.width; ++var1) {
         for(int var2 = 0; var2 < this.height; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-64"
   )
   @Export("removeWall")
   public void removeWall(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.remove(var1, var2, 128);
            this.remove(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 2);
            this.remove(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 8);
            this.remove(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 32);
            this.remove(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.remove(var1, var2, 1);
            this.remove(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 4);
            this.remove(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 16);
            this.remove(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 64);
            this.remove(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.remove(var1, var2, 130);
            this.remove(var1 - 1, var2, 8);
            this.remove(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 10);
            this.remove(var1, var2 + 1, 32);
            this.remove(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 40);
            this.remove(var1 + 1, var2, 128);
            this.remove(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 160);
            this.remove(var1, var2 - 1, 2);
            this.remove(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.remove(var1, var2, 65536);
               this.remove(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 1024);
               this.remove(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 4096);
               this.remove(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 16384);
               this.remove(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.remove(var1, var2, 512);
               this.remove(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 2048);
               this.remove(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 8192);
               this.remove(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 32768);
               this.remove(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.remove(var1, var2, 66560);
               this.remove(var1 - 1, var2, 4096);
               this.remove(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 5120);
               this.remove(var1, var2 + 1, 16384);
               this.remove(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 20480);
               this.remove(var1 + 1, var2, 65536);
               this.remove(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 81920);
               this.remove(var1, var2 - 1, 1024);
               this.remove(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-266514345"
   )
   @Export("unblock")
   public void unblock(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1928753278"
   )
   @Export("removeObject")
   public void removeObject(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.remove(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-20"
   )
   @Export("block")
   public void block(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1623627732"
   )
   @Export("addObject")
   public void addObject(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.add(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1196820482"
   )
   @Export("addWall")
   public void addWall(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.add(var1, var2, 128);
            this.add(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.add(var1, var2, 2);
            this.add(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.add(var1, var2, 8);
            this.add(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.add(var1, var2, 32);
            this.add(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.add(var1, var2, 1);
            this.add(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.add(var1, var2, 4);
            this.add(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.add(var1, var2, 16);
            this.add(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.add(var1, var2, 64);
            this.add(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.add(var1, var2, 130);
            this.add(var1 - 1, var2, 8);
            this.add(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.add(var1, var2, 10);
            this.add(var1, var2 + 1, 32);
            this.add(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.add(var1, var2, 40);
            this.add(var1 + 1, var2, 128);
            this.add(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.add(var1, var2, 160);
            this.add(var1, var2 - 1, 2);
            this.add(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.add(var1, var2, 65536);
               this.add(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.add(var1, var2, 1024);
               this.add(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.add(var1, var2, 4096);
               this.add(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.add(var1, var2, 16384);
               this.add(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.add(var1, var2, 512);
               this.add(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.add(var1, var2, 2048);
               this.add(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.add(var1, var2, 8192);
               this.add(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.add(var1, var2, 32768);
               this.add(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.add(var1, var2, 66560);
               this.add(var1 - 1, var2, 4096);
               this.add(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.add(var1, var2, 5120);
               this.add(var1, var2 + 1, 16384);
               this.add(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.add(var1, var2, 20480);
               this.add(var1 + 1, var2, 65536);
               this.add(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.add(var1, var2, 81920);
               this.add(var1, var2 - 1, 1024);
               this.add(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "32"
   )
   public void method3075(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "1286251463"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3453 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "483297471"
   )
   static final void method3106() {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLOSED_WINDOW);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3637(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3638()) {
         if(var0.owner == 0 || var0.owner == 3) {
            class110.method2145(var0, true);
         }
      }

      if(Client.field1078 != null) {
         class45.method647(Client.field1078);
         Client.field1078 = null;
      }

   }
}
