
#ifndef _MYDLL_H
#define _MYDLL_H

#ifdef __DLL__
#define DLL_E __declspec(dllexport)
#else
#define DLL_E __declspec(dllimport)
#endif

#include "netmodul.h"
void TCPServer1Execute(TIdPeerThread *AThread);
namespace net
{
DLL_E struct Man
        {
        char* name;
        int bit_X;
        int ball_X;
        int ball_Y;
        int status;
        };
extern "C" int DLL_E open(char*ip,int port);
extern "C" void DLL_E close();
extern "C" int DLL_E send(Man a);
extern "C" Man DLL_E getData(); 
}
#endif


