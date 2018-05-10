import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class151 implements Runnable {
   @ObfuscatedName("w")
   Thread field1950;
   @ObfuscatedName("m")
   InputStream field1956;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1082484171
   )
   int field1951;
   @ObfuscatedName("b")
   byte[] field1952;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1603981301
   )
   int field1953;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1202012067
   )
   int field1949;
   @ObfuscatedName("h")
   IOException field1955;

   class151(InputStream var1, int var2) {
      this.field1953 = 0;
      this.field1949 = 0;
      this.field1956 = var1;
      this.field1951 = var2 + 1;
      this.field1952 = new byte[this.field1951];
      this.field1950 = new Thread(this);
      this.field1950.setDaemon(true);
      this.field1950.start();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "27"
   )
   boolean method3222(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field1951) {
         synchronized(this) {
            int var3;
            if(this.field1953 <= this.field1949) {
               var3 = this.field1949 - this.field1953;
            } else {
               var3 = this.field1951 - this.field1953 + this.field1949;
            }

            if(var3 < var1) {
               if(this.field1955 != null) {
                  throw new IOException(this.field1955.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   int method3227() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field1953 <= this.field1949) {
            var2 = this.field1949 - this.field1953;
         } else {
            var2 = this.field1951 - this.field1953 + this.field1949;
         }

         if(var2 <= 0 && this.field1955 != null) {
            throw new IOException(this.field1955.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "785358038"
   )
   int method3223() throws IOException {
      synchronized(this) {
         if(this.field1953 == this.field1949) {
            if(this.field1955 != null) {
               throw new IOException(this.field1955.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field1952[this.field1953] & 255;
            this.field1953 = (this.field1953 + 1) % this.field1951;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1576161114"
   )
   int method3224(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field1953 <= this.field1949) {
               var5 = this.field1949 - this.field1953;
            } else {
               var5 = this.field1951 - this.field1953 + this.field1949;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field1955 != null) {
               throw new IOException(this.field1955.toString());
            } else {
               if(var3 + this.field1953 <= this.field1951) {
                  System.arraycopy(this.field1952, this.field1953, var1, var2, var3);
               } else {
                  int var6 = this.field1951 - this.field1953;
                  System.arraycopy(this.field1952, this.field1953, var1, var2, var6);
                  System.arraycopy(this.field1952, 0, var1, var6 + var2, var3 - var6);
               }

               this.field1953 = (var3 + this.field1953) % this.field1951;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   void method3225() {
      synchronized(this) {
         if(this.field1955 == null) {
            this.field1955 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field1950.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field1955 != null) {
                  return;
               }

               if(this.field1953 == 0) {
                  var1 = this.field1951 - this.field1949 - 1;
               } else if(this.field1953 <= this.field1949) {
                  var1 = this.field1951 - this.field1949;
               } else {
                  var1 = this.field1953 - this.field1949 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field1956.read(this.field1952, this.field1949, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field1955 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field1949 = (var7 + this.field1949) % this.field1951;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Lkc;",
      garbageValue = "135497540"
   )
   public static class307[] method3235() {
      return new class307[]{class307.field3742, class307.field3740, class307.field3743};
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "93"
   )
   static final void method3234(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         ScriptState.preferences.hideRoofs = !ScriptState.preferences.hideRoofs;
         Enum.method5008();
         if(ScriptState.preferences.hideRoofs) {
            OwnWorldComparator.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            OwnWorldComparator.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(var0.equalsIgnoreCase("renderself")) {
         Client.field711 = !Client.field711;
      }

      if(var0.equalsIgnoreCase("mouseovertext")) {
         Client.field740 = !Client.field740;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("showcoord")) {
            Preferences.renderOverview.field3846 = !Preferences.renderOverview.field3846;
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            ChatLineBuffer.method2018();
         }
      }

      PacketNode var1 = DecorativeObject.method3115(ClientPacket.field2201, Client.field739.field1250);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field739.method2019(var1);
   }
}
